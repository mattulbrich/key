package org.key_project.key4eclipse.util.test.testcase.swtbot;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLabel;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.junit.Test;
import org.key_project.key4eclipse.util.eclipse.WorkbenchUtil;
import org.key_project.key4eclipse.util.eclipse.swt.dialog.ElementTableSelectionDialog;
import org.key_project.key4eclipse.util.java.CollectionUtil;
import org.key_project.key4eclipse.util.java.thread.AbstractRunnableWithResult;
import org.key_project.key4eclipse.util.java.thread.IRunnableWithResult;
import org.key_project.key4eclipse.util.test.util.ArrayObject;
import org.key_project.key4eclipse.util.test.util.ArrayObjectLabelProvider;
import org.key_project.key4eclipse.util.test.util.TestUtilsUtil;

/**
 * SWT Bot tests for {@link ElementTableSelectionDialog}. 
 * @author Martin Hentschel
 */
public class SWTBotTableSelectionDialogTest extends TestCase {
    /**
     * Opens the dialog with single selection.
     */
    @Test
    public void testMultiSelectionResult() {
        // Create model
        ArrayObject o1 = new ArrayObject("o1");
        ArrayObject o2 = new ArrayObject("o2");
        ArrayObject o3 = new ArrayObject("o3");
        ArrayObject o4 = new ArrayObject("o4");
        final List<ArrayObject> input = CollectionUtil.toList(o1, o2, o3, o4);
        // Get active shell
        IRunnableWithResult<Shell> shellRun = new AbstractRunnableWithResult<Shell>() {
            @Override
            public void run() {
                setResult(WorkbenchUtil.getActiveShell());
            }
        };
        Display.getDefault().syncExec(shellRun);
        // Create dialog
        Shell parent = shellRun.getResult();
        IContentProvider contentProvider = ArrayContentProvider.getInstance();
        ILabelProvider labelProvider = new ArrayObjectLabelProvider();
        ElementTableSelectionDialog dialog = new ElementTableSelectionDialog(parent, contentProvider, labelProvider);
        dialog.setTitle("SWTBotTableSelectionDialogTest");
        dialog.setMessage("testSignleSelectionResult");
        dialog.setInput(input);
        dialog.setAllowMultiple(true);
        // Open dialog again and approve it
        openDialog(dialog, new int[] {1}, ElementTableSelectionDialog.OK, o2);
        // Open dialog and cancel it
        openDialog(dialog, new int[] {1}, ElementTableSelectionDialog.CANCEL);
        // Open dialog with multiple selections and approve it
        openDialog(dialog, new int[] {1, 3}, ElementTableSelectionDialog.OK, o2, o4);
        // Open dialog with multiple selections and cancel it
        openDialog(dialog, new int[] {1, 3}, ElementTableSelectionDialog.CANCEL);
    }
    
    /**
     * Opens the dialog with single selection.
     */
    @Test
    public void testSignleSelectionResult() {
        // Create model
        ArrayObject o1 = new ArrayObject("o1");
        ArrayObject o2 = new ArrayObject("o2");
        ArrayObject o3 = new ArrayObject("o3");
        ArrayObject o4 = new ArrayObject("o4");
        final List<ArrayObject> input = CollectionUtil.toList(o1, o2, o3, o4);
        // Get active shell
        IRunnableWithResult<Shell> shellRun = new AbstractRunnableWithResult<Shell>() {
            @Override
            public void run() {
                setResult(WorkbenchUtil.getActiveShell());
            }
        };
        Display.getDefault().syncExec(shellRun);
        // Create dialog
        Shell parent = shellRun.getResult();
        IContentProvider contentProvider = ArrayContentProvider.getInstance();
        ILabelProvider labelProvider = new ArrayObjectLabelProvider();
        ElementTableSelectionDialog dialog = new ElementTableSelectionDialog(parent, contentProvider, labelProvider);
        dialog.setTitle("SWTBotTableSelectionDialogTest");
        dialog.setMessage("testSignleSelectionResult");
        dialog.setInput(input);
        // Open dialog again and approve it
        openDialog(dialog, new int[] {1}, ElementTableSelectionDialog.OK, o2);
        // Open dialog and cancel it
        openDialog(dialog, new int[] {1}, ElementTableSelectionDialog.CANCEL);
        // Make sure that multiple selections are not possible
        try {
            openDialog(dialog, new int[] {1, 2}, ElementTableSelectionDialog.OK);
        }
        catch (IllegalArgumentException e) {
            assertEquals("Table does not support multi selection.", e.getMessage());
        }
    }
    
    /**
     * Opens the given {@link ElementTableSelectionDialog} and makes sure
     * that the correct result is returned.
     * @param dialog The {@link ElementTableSelectionDialog} to open.
     * @param indicesToSelect The rows to select.
     * @param expectedDialogResult The expected dialog result.
     * @param expectedSelection The expected selection.
     */
    protected void openDialog(final ElementTableSelectionDialog dialog,
                              int[] indicesToSelect,
                              int expectedDialogResult,
                              Object... expectedSelection) {
        // Open dialog
        IRunnableWithResult<Integer> run = new AbstractRunnableWithResult<Integer>() {
            @Override
            public void run() {
                setResult(dialog.open());
            }
        };
        Display.getDefault().asyncExec(run);
        // Get dialog
        SWTBot bot = new SWTBot();
        SWTBotShell shell = bot.shell("SWTBotTableSelectionDialogTest");
        // Test label
        SWTBotLabel label = shell.bot().label("testSignleSelectionResult");
        assertEquals("testSignleSelectionResult", label.getText());
        // Make sure that the correct values are shown
        SWTBotTable table = shell.bot().table();
        TestUtilsUtil.assertTableRows(table, "o1", "o2", "o3", "o4");
        // Select second item
        table.select(indicesToSelect);
        // Approve dialog
        SWTBotButton okButton = shell.bot().button(ElementTableSelectionDialog.OK == expectedDialogResult ? "OK" : "Cancel");
        okButton.click();
        assertFalse(shell.isOpen());
        Integer dialogResult = run.getResult();
        assertNotNull(dialogResult);
        assertEquals(expectedDialogResult, dialogResult.intValue());
        if (expectedSelection.length >= 1) {
            assertEquals(expectedSelection[0], dialog.getFirstResult());
        }
        else {
            assertNull(dialog.getFirstResult());
        }
        assertNotNull(dialog.getResult());
        assertEquals(expectedSelection.length, dialog.getResult().length);
        for (int i = 0; i < expectedSelection.length; i++) {
            assertEquals(expectedSelection[i], dialog.getResult()[i]);
        }
    }
}