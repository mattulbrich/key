package org.key_project.util.eclipse;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewFolderResourceWizard;

/**
 * Provides static methods 
 * @author Martin Hentschel
 */
public final class WorkbenchUtil {
    /**
     * The ID of the default text editor.
     */
    public static final String DEFAULT_TEXT_EDITOR_ID = "org.eclipse.ui.DefaultTextEditor";
    
    /**
     * Forbid instances.
     */
    private WorkbenchUtil() {
    }
    
    /**
     * Opens the perspective with the given ID in the active {@link IWorkbenchPage}.
     * @param perspectiveId The ID of the perspective to open.
     * @return The opened {@link IPerspectiveDescriptor} or {@code null} if no {@link IWorkbenchPage} is active.
     */
    public static IPerspectiveDescriptor openPerspective(String perspectiveId) {
       IWorkbenchPage page = getActivePage();
       if (page != null) {
          IPerspectiveDescriptor perspective = PlatformUI.getWorkbench().getPerspectiveRegistry().findPerspectiveWithId(perspectiveId);
          page.setPerspective(perspective);
          return perspective;
       }
       else {
          return null;
       }
    }

    /**
     * Closes the given {@link IPerspectiveDescriptor} in the active {@link IWorkbenchPage}.
     * @param perspectiveToClose The {@link IPerspectiveDescriptor} to close.
     * @param saveParts Whether the page's parts should be saved if closed
     * @param closePage Close the {@link IWorkbenchPage}? 
     */
    public static void closePerspective(IPerspectiveDescriptor perspectiveToClose, boolean saveParts, boolean closePage) {
       if (perspectiveToClose != null) {
          IWorkbenchPage page = getActivePage();
          if (page != null) {
             page.closePerspective(perspectiveToClose, saveParts, closePage);
          }
       }
    }
    
    /**
     * Returns the active {@link IWorkbenchWindow} if available.
     * @return The active {@link IWorkbenchWindow} or {@code null} if no one is available.
     */
    public static IWorkbenchWindow getActiveWorkbenchWindow() {
        IWorkbench workbench = PlatformUI.getWorkbench();
        if (workbench != null) {
            return workbench.getActiveWorkbenchWindow();
        }
        else {
            return null;
        }
    }
    
    /**
     * Returns the active {@link IWorkbenchPage} if available.
     * @return The active {@link IWorkbenchPage} or {@code null} if no one is available.
     */
    public static IWorkbenchPage getActivePage() {
        IWorkbenchWindow window = getActiveWorkbenchWindow();
        if (window != null) {
            return window.getActivePage();
        }
        else {
            return null;
        }
    }
    
    /**
     * Returns the active {@link IWorkbenchPart} if available.
     * @return The active {@link IWorkbenchPart} or {@code null} if no one is available.
     */
    public static IWorkbenchPart getActivePart() {
        IWorkbenchPage page = getActivePage();
        if (page != null) {
            return page.getActivePart();
        }
        else {
            return null;
        }
    }
    
    /**
     * Returns the active {@link IEditorPart} if available.
     * @return The active {@link IEditorPart} or {@code null} if no one is available.
     */
    public static IEditorPart getActiveEditor() {
        IWorkbenchPage page = getActivePage();
        if (page != null) {
            return page.getActiveEditor();
        }
        else {
            return null;
        }
    }
    
    /**
     * Returns the active {@link Shell} if available.
     * @return The active {@link Shell} or {@code null} if no one is available.
     */
    public static Shell getActiveShell() {
        IWorkbenchWindow window = getActiveWorkbenchWindow();
        if (window != null) {
            return window.getShell();
        }
        else {
            return null;
        }
    }
    
    /**
     * Selects and reveals the given {@link IResource}.
     * @param resource The {@link IResource} to show.
     */
    public static void selectAndReveal(IResource resource) {
        IWorkbench workbench = PlatformUI.getWorkbench();
        if (workbench != null) {
            IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
            if (window != null) {
                BasicNewFolderResourceWizard.selectAndReveal(resource, window);
            }
        }
    }
    
    /**
     * Opens an eclipse editor for the given {@link IFile}. 
     * @param file The {@link IFile} to open.
     * @return The opened eclipse editor.
     * @throws PartInitException Occurred Exception.
     */
    public static IEditorPart openEditor(IFile file) throws PartInitException {
        if (file != null) {
            IWorkbench workbench = PlatformUI.getWorkbench();
            if (workbench != null) {
                IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
                if (window != null) {
                    IWorkbenchPage page = window.getActivePage();
                    if (page != null) {
                        return IDE.openEditor(page, file);
                    }
                    else {
                        throw new PartInitException("Active workbench page is not available");
                    }
                }
                else {
                    throw new PartInitException("Active workbench window is not available");
                }
            }
            else {
                throw new PartInitException("Workbench is not available");
            }
        }
        else {
            throw new PartInitException("No file to open defined.");
        }
    }

    /**
     * Closes the given eclipse editor.
     * @param editor The editor to close.
     * @param save Save changes?
     * @return {@code true} if the editor was successfully closed, and {@code false} if the editor is still open.
     */
    public static boolean closeEditor(IEditorPart editor, boolean save) {
        if (editor != null) {
            boolean closed = false;
            IEditorSite site = editor.getEditorSite();
            if (site != null) {
                IWorkbenchPage page = site.getPage();
                if (page != null) {
                    closed = page.closeEditor(editor, save);
                }
            }
            return closed;
        }
        else {
            return true;
        }
    }

    /**
     * Shows the view identified by the given view id in this page and gives it focus. 
     * If there is a view identified by the given view id (and with no secondary id) already open in this page, 
     * it is given focus.
     * @param viewId The ID of the view to open.
     * @return The opened or reactivated {@link IViewPart} that has now the focus.
     * @throws PartInitException Occurred Exception.
     */
    public static IViewPart openView(String viewId) throws PartInitException {
        IWorkbenchPage page = getActivePage();
        if (page != null) {
            return page.showView(viewId);
        }
        else {
            return null;
        }
    }
    
    /**
     * Checks if the given {@link IWorkbenchPart} is active.
     * @param part The {@link IWorkbenchPart} to check.
     * @return {@code true} is active, {@code false} is not active.
     */
    public static boolean isActive(IWorkbenchPart part) {
        return part != null && part.getSite().getPage().getActivePart() == part;
    }

    /**
     * Activates the given part. The part will be brought to the front and given focus. The part must belong to this page.
     * @param part Activates the given {@link IWorkbenchPart}.
     */
    public static void activate(IWorkbenchPart part) {
        if (part != null) {
            part.getSite().getPage().activate(part);
        }
    }

    /**
     * Closes the given {@link IViewPart}. 
     * @param part The {@link IViewPart} to close.
     */
    public static void closeView(IViewPart view) {
        if (view != null) {
           view.getSite().getPage().hideView(view);
        }
    }

    /**
     * Searches an {@link IViewPart} with the given ID in the active {@link IWorkbenchPage}.
     * @param viewId The view ID to search.
     * @return The found {@link IViewPart} or {@code null} if no one was found.
     */
    public static IViewPart findView(String viewId) {
        IWorkbenchPage page = getActivePage();
        return page != null ? page.findView(viewId) : null;
    }
}