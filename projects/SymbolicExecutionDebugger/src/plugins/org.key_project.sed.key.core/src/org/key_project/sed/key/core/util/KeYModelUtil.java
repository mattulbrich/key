package org.key_project.sed.key.core.util;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.internal.ui.javaeditor.ASTProvider;
import org.key_project.key4eclipse.starter.core.util.KeYUtil;
import org.key_project.sed.core.model.ISEDThread;
import org.key_project.sed.key.core.model.IKeYSEDDebugNode;
import org.key_project.sed.key.core.model.KeYBranchCondition;
import org.key_project.sed.key.core.model.KeYBranchNode;
import org.key_project.sed.key.core.model.KeYDebugTarget;
import org.key_project.sed.key.core.model.KeYExceptionalTermination;
import org.key_project.sed.key.core.model.KeYLoopCondition;
import org.key_project.sed.key.core.model.KeYLoopNode;
import org.key_project.sed.key.core.model.KeYMethodCall;
import org.key_project.sed.key.core.model.KeYMethodReturn;
import org.key_project.sed.key.core.model.KeYStatement;
import org.key_project.sed.key.core.model.KeYTermination;
import org.key_project.util.java.IOUtil;
import org.key_project.util.java.IOUtil.LineInformation;

import de.uka.ilkd.key.java.PositionInfo;
import de.uka.ilkd.key.symbolic_execution.model.IExecutionBranchCondition;
import de.uka.ilkd.key.symbolic_execution.model.IExecutionBranchNode;
import de.uka.ilkd.key.symbolic_execution.model.IExecutionLoopCondition;
import de.uka.ilkd.key.symbolic_execution.model.IExecutionLoopNode;
import de.uka.ilkd.key.symbolic_execution.model.IExecutionMethodCall;
import de.uka.ilkd.key.symbolic_execution.model.IExecutionMethodReturn;
import de.uka.ilkd.key.symbolic_execution.model.IExecutionNode;
import de.uka.ilkd.key.symbolic_execution.model.IExecutionStatement;
import de.uka.ilkd.key.symbolic_execution.model.IExecutionTermination;

/**
 * Provides utility methods which are used by {@link IKeYSEDDebugNode}
 * implementations to compute their content and child {@link IKeYSEDDebugNode}s.
 * @author Martin Hentschel
 */
@SuppressWarnings("restriction")
public final class KeYModelUtil {
   /**
    * Forbid instances.
    */
   private KeYModelUtil() {
   }

   /**
    * <p>
    * Creates new {@link IKeYSEDDebugNode}s for new {@link IExecutionNode}s
    * which are added after the existing {@link IKeYSEDDebugNode}s.
    * </p>
    * <p>
    * The assumption is that new children are only added in the end and
    * that existing children are never replaced or removed.
    * </p>
    * @param parent The parent {@link IKeYSEDDebugNode} in the debug model.
    * @param oldChildren The existing {@link IKeYSEDDebugNode}s to keep.
    * @param executionChildren The {@link IExecutionNode}s of the execution tree to create debug model representations for.
    * @return The created debug model representations.
    * @throws DebugException Occurred Exception.
    */
   public static IKeYSEDDebugNode<?>[] updateChildren(IKeYSEDDebugNode<?> parent, 
                                                      IKeYSEDDebugNode<?>[] oldChildren, 
                                                      IExecutionNode[] executionChildren) throws DebugException {
      if (executionChildren != null) {
         IKeYSEDDebugNode<?>[] result = new IKeYSEDDebugNode<?>[executionChildren.length];
         // Add old children
         System.arraycopy(oldChildren, 0, result, 0, oldChildren.length);
         // Create new children
         for (int i = oldChildren.length; i < executionChildren.length; i++) {
            result[i] = createChild(parent, executionChildren[i]);
         }
         return result;
      }
      else {
         return new IKeYSEDDebugNode<?>[0];
      }
   }
   
   /**
    * Creates new {@link IKeYSEDDebugNode}s for the given {@link IExecutionNode}s.
    * @param parent The parent {@link IKeYSEDDebugNode} in the debug model.
    * @param executionChildren The {@link IExecutionNode}s of the execution tree to create debug model representations for.
    * @return The created debug model representations.
    * @throws DebugException Occurred Exception.
    */
   public static IKeYSEDDebugNode<?>[] createChildren(IKeYSEDDebugNode<?> parent, 
                                                      IExecutionNode[] executionChildren) throws DebugException {
      if (executionChildren != null) {
         IKeYSEDDebugNode<?>[] result = new IKeYSEDDebugNode<?>[executionChildren.length];
         for (int i = 0; i < executionChildren.length; i++) {
            result[i] = createChild(parent, executionChildren[i]);
         }
         return result;
      }
      else {
         return new IKeYSEDDebugNode<?>[0];
      }
   }

   /**
    * Creates an {@link IKeYSEDDebugNode} for the given {@link IExecutionNode}
    * as child of the given parent {@link IKeYSEDDebugNode}.
    * @param parent The parent {@link IKeYSEDDebugNode} in the debug model.
    * @param executionNode The {@link IExecutionNode} of the execution tree.
    * @return The created {@link IKeYSEDDebugNode}.
    * @throws DebugException Occurred Exception.
    */
   protected static IKeYSEDDebugNode<?> createChild(IKeYSEDDebugNode<?> parent, IExecutionNode executionNode) throws DebugException {
      KeYDebugTarget target = parent.getDebugTarget();
      ISEDThread thread = parent.getThread();
      IKeYSEDDebugNode<?> result;
      if (executionNode instanceof IExecutionBranchCondition) {
         result = new KeYBranchCondition(target, parent, thread, (IExecutionBranchCondition)executionNode);
      }
      else if (executionNode instanceof IExecutionBranchNode) {
         result = new KeYBranchNode(target, parent, thread, (IExecutionBranchNode)executionNode);
      }
      else if (executionNode instanceof IExecutionLoopCondition) {
         result = new KeYLoopCondition(target, parent, thread, (IExecutionLoopCondition)executionNode);
      }
      else if (executionNode instanceof IExecutionLoopNode) {
         result = new KeYLoopNode(target, parent, thread, (IExecutionLoopNode)executionNode);
      }
      else if (executionNode instanceof IExecutionMethodCall) {
         result = new KeYMethodCall(target, parent, thread, (IExecutionMethodCall)executionNode);
      }
      else if (executionNode instanceof IExecutionMethodReturn) {
         result = new KeYMethodReturn(target, parent, thread, (IExecutionMethodReturn)executionNode);
      }
      else if (executionNode instanceof IExecutionStatement) {
         result = new KeYStatement(target, parent, thread, (IExecutionStatement)executionNode);
      }
      else if (executionNode instanceof IExecutionTermination) {
         IExecutionTermination terminationExecutionNode = (IExecutionTermination)executionNode;
         if (terminationExecutionNode.isExceptionalTermination()) {
            result = new KeYExceptionalTermination(target, parent, thread, (IExecutionTermination)executionNode);
         }
         else {
            result = new KeYTermination(target, parent, thread, (IExecutionTermination)executionNode);
         }
      }
      else {
         throw new DebugException(LogUtil.getLogger().createErrorStatus("Not supported execution node \"" + executionNode + "\"."));
      }
      target.registerDebugNode(result);
      return result;
   }
   
   /**
    * Returns the name of the source file defined by the given {@link PositionInfo}.
    * @param posInfo The {@link PositionInfo} to extract source file from.
    * @return The source file name or {@code null} if not available.
    */
   public static String getSourceName(PositionInfo posInfo) {
      if (posInfo.getFileName() != null) {
         File file = new File(posInfo.getFileName()); // posInfo.getFileName() is a path to a file
         return file.getName();
      }
      else if (posInfo.getParentClass() != null) {
         File file = new File(posInfo.getParentClass()); // posInfo.getParentClass() is a path to a file
         return file.getName();
      }
      else {
         return null;
      }
   }

   /**
    * Converts the given {@link PositionInfo} into a {@link SourceLocation}.
    * This includes to convert position information defined via row and column
    * of the {@link PositionInfo} into character offset from file beginning
    * for the {@link SourceLocation}.
    * @param posInfo The {@link PositionInfo} to convert.
    * @return The created {@link PositionInfo}.
    */
   public static SourceLocation convertToSourceLocation(PositionInfo posInfo) {
      try {
         if (posInfo != null && posInfo != PositionInfo.UNDEFINED) {
            // Try to find the source file.
            File file = null;
            if (posInfo.getFileName() != null) {
               file = new File(posInfo.getFileName());
            }
            else if (posInfo.getParentClass() != null) {
               file = new File(posInfo.getParentClass());
            }
            // Check if a source file is available
            int charStart = -1;
            int charEnd = -1;
            int lineNumber = -1;
            if (file != null) {
               // Set source location
               LineInformation[] infos = IOUtil.computeLineInformation(file);
               if (posInfo.getStartPosition() != null) {
                  int line = posInfo.getStartPosition().getLine() - 1;
                  int column = posInfo.getStartPosition().getColumn();
                  if (line >= 0 && line < infos.length) {
                     LineInformation info = infos[line];
                     int offset = info.getOffset() + KeYUtil.normalizeRecorderColumn(column, info.getTabIndices());
                     charStart = offset;
                  }
               }
               if (posInfo.getEndPosition() != null) {
                  int line = posInfo.getEndPosition().getLine() - 1;
                  int column = posInfo.getEndPosition().getColumn();
                  if (line >= 0 && line < infos.length) {
                     LineInformation info = infos[line];
                     int offset = info.getOffset() + KeYUtil.normalizeRecorderColumn(column, info.getTabIndices());
                     charEnd = offset;
                  }
               }
               // Check if source start and end is defined.
               if (charStart < 0 || charEnd < 0) {
                  // Unset start and end indices
                  charStart = -1;
                  charEnd = -1;
                  // Try to set a line number as backup
                  if (posInfo.getEndPosition() != null) {
                     lineNumber = posInfo.getEndPosition().getLine();
                  }
               }
               return new SourceLocation(lineNumber, charStart, charEnd);
            }
            else {
               return SourceLocation.UNDEFINED;
            }
         }
         else {
            return SourceLocation.UNDEFINED;
         }
      }
      catch (IOException e) {
         LogUtil.getLogger().logError(e);
         return SourceLocation.UNDEFINED;
      }
   }
   
   /**
    * Tries to update the given {@link SourceLocation} of the given
    * {@link IStackFrame} with the location provided by JDT. If possible
    * the new location is returned and the original location otherwise.
    * @param frame The {@link IStackFrame} which provides the given {@link SourceLocation}.
    * @param sourceLocation The initial {@link SourceLocation}.
    * @return The updated {@link SourceLocation} or the initial {@link SourceLocation}.
    * @throws DebugException Occurred Exception.
    */
   public static SourceLocation updateLocationFromAST(IStackFrame frame,
                                                         SourceLocation sourceLocation) throws DebugException {
      try {
         SourceLocation result = sourceLocation;
         if (sourceLocation != null && sourceLocation.getCharEnd() >= 0) {
            ICompilationUnit compilationUnit = findCompilationUnit(frame);
            if (compilationUnit != null) {
               ASTNode root = parse(compilationUnit, sourceLocation.getCharStart(), sourceLocation.getCharEnd() - sourceLocation.getCharStart());
               ASTNode statementNode = ASTNodeByEndIndexSearcher.search(root, sourceLocation.getCharEnd());
               if (statementNode != null) {
                  result = new SourceLocation(-1, 
                                              statementNode.getStartPosition(), 
                                              statementNode.getStartPosition() + statementNode.getLength());
               }
            }
         }
         return result;
      }
      catch (Exception e) {
         throw new DebugException(LogUtil.getLogger().createErrorStatus(e));
      }
   }

   /**
    * Tries to find an {@link ICompilationUnit} for the given {@link IStackFrame}.
    * @param frame The given {@link IStackFrame} for that is an {@link ICompilationUnit} required.
    * @return The found {@link ICompilationUnit}.
    */
   public static ICompilationUnit findCompilationUnit(IStackFrame frame) {
      ICompilationUnit result = null;
      if (frame != null) {
         Object source = frame.getLaunch().getSourceLocator().getSourceElement(frame);
         if (source instanceof IFile) {
            IJavaElement element = JavaCore.create((IFile)source);
            if (element instanceof ICompilationUnit) {
               result = (ICompilationUnit)element;
            }
         }
      }
      return result;
   }
   
   /**
    * Searches the {@link IMethod} as JDT representation which ends
    * at the given index.
    * @param cu The {@link ICompilationUnit} to search in.
    * @param endIndex The index in the file at that the required method ends.
    * @return The found {@link IMethod} or {@code null} if the JDT representation is not available.
    * @throws JavaModelException Occurred Exception.
    * @throws IOException Occurred Exception.
    */
   public static IMethod findJDTMethod(ICompilationUnit cu, int endIndex) throws JavaModelException, IOException {
      IMethod result = null;
      if (cu != null) {
         IType[] types = cu.getAllTypes();
         int i = 0;
         while (result == null && i < types.length) {
            IMethod[] methods = types[i].getMethods();
            int j = 0;
            while (result == null && j < methods.length) {
               ISourceRange methodRange = methods[j].getSourceRange();
               if (endIndex == methodRange.getOffset() + methodRange.getLength()) {
                  result = methods[j];
               }
               j++;
            }
            i++;
         }
      }
      return result;
   }
   
   /**
    * Parses the given {@link ICompilationUnit} in the specified range into an AST. 
    * @param compilationUnit The {@link ICompilationUnit} to parse.
    * @param offset The start index in the text to parse.
    * @param length The length of the text to parse.
    * @return The {@link ASTNode} which is the root of the AST.
    */
   protected static ASTNode parse(ICompilationUnit compilationUnit, int offset, int length) {
      ASTParser parser = ASTParser.newParser(ASTProvider.SHARED_AST_LEVEL); // Hopefully always the newest AST level (e.g. AST.JLS4)
      parser.setSource(compilationUnit);
      parser.setSourceRange(offset, length);
      return parser.createAST(null);
   }
   
   /**
    * Represents a location in a source file.
    * @author Martin Hentschel
    */
   public static class SourceLocation {
      /**
       * Location which indicates that no location is defined.
       */
      public static final SourceLocation UNDEFINED = new SourceLocation(-1, -1, -1);
      
      /**
       * The line number to select.
       */
      private int lineNumber;
      
      /**
       * The index of the start character to select.
       */
      private int charStart;
      
      /**
       * The index of the end character to select.
       */
      private int charEnd;
      
      /**
       * Constructor.
       * @param lineNumber The line number to select.
       * @param charStart The index of the start character to select.
       * @param charEnd The index of the end character to select.
       */
      public SourceLocation(int lineNumber, int charStart, int charEnd) {
         super();
         this.lineNumber = lineNumber;
         this.charStart = charStart;
         this.charEnd = charEnd;
      }
      
      /**
       * Returns The line number to select.
       * @return The line number to select.
       */
      public int getLineNumber() {
         return lineNumber;
      }
      
      /**
       * Returns The index of the start character to select.
       * @return The index of the start character to select.
       */
      public int getCharStart() {
         return charStart;
      }
      
      /**
       * Returns The index of the end character to select.
       * @return The index of the end character to select.
       */
      public int getCharEnd() {
         return charEnd;
      }
   }
}