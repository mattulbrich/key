package org.key_project.sed.core.test.example.fixed_launch_content;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.key_project.sed.core.model.ISEDBranchCondition;
import org.key_project.sed.core.model.ISEDBranchNode;
import org.key_project.sed.core.model.ISEDDebugTarget;
import org.key_project.sed.core.model.ISEDExceptionalTermination;
import org.key_project.sed.core.model.ISEDLoopCondition;
import org.key_project.sed.core.model.ISEDLoopNode;
import org.key_project.sed.core.model.ISEDMethodCall;
import org.key_project.sed.core.model.ISEDMethodReturn;
import org.key_project.sed.core.model.ISEDStatement;
import org.key_project.sed.core.model.ISEDTermination;
import org.key_project.sed.core.model.ISEDThread;
import org.key_project.sed.core.model.memory.SEDMemoryBranchCondition;
import org.key_project.sed.core.model.memory.SEDMemoryBranchNode;
import org.key_project.sed.core.model.memory.SEDMemoryDebugTarget;
import org.key_project.sed.core.model.memory.SEDMemoryExceptionalTermination;
import org.key_project.sed.core.model.memory.SEDMemoryLoopCondition;
import org.key_project.sed.core.model.memory.SEDMemoryLoopNode;
import org.key_project.sed.core.model.memory.SEDMemoryMethodCall;
import org.key_project.sed.core.model.memory.SEDMemoryMethodReturn;
import org.key_project.sed.core.model.memory.SEDMemoryStatement;
import org.key_project.sed.core.model.memory.SEDMemoryTermination;
import org.key_project.sed.core.model.memory.SEDMemoryThread;

/**
 * <p>
 * This {@link LaunchConfigurationDelegate} is responsible to open
 * a fixed model in the given {@link ILaunch}.
 * </p>
 * <p>
 * The following tree is contained:
 * <pre>
 * Fixed Example Test [Fixed Example] ({@link ILaunch})
 *    Fixed Example Target ({@link ISEDDebugTarget})
 *         Fixed Example Thread ({@link ISEDThread})
 *            int x = 1; ({@link ISEDStatement})
 *               while (x == 1) ({@link ISEDLoopNode})
 *                  x == 1 ({@link ISEDLoopCondition})
 *                     x++; ({@link ISEDStatement})
 *                        int y = 2; ({@link ISEDStatement})
 *                           int result = (x + y) / z; ({@link ISEDStatement})
 *                              z == 0 ({@link ISEDBranchCondition})
 *                                 throws DivisionByZeroException() ({@link ISEDExceptionalTermination}) 
 *                              z != 0 ({@link ISEDBranchCondition})
 *                                 foo(result) ({@link ISEDMethodCall})
 *                                    if (result >= 0) ({@link ISEDBranchNode})
 *                                       result < 0 ({@link ISEDBranchCondition})
 *                                          return -1 ({@link ISEDMethodReturn})
 *                                             <end> ({@link ISEDTermination})
 *                                       result >= 0 ({@link ISEDBranchCondition})
 *                                          return 1 ({@link ISEDMethodReturn})
 *                                             <end> ({@link ISEDTermination})
 *   
 * </pre>
 * </p>
 * @author Martin Hentschel
 */
public class FixedExampleLaunchConfigurationDelegate extends LaunchConfigurationDelegate {
   /**
    * The used model identifier.
    */
   public static final String MODEL_IDENTIFIER = "org.key_project.sed.core.test.example.fixed_launch_content";

   /**
     * {@inheritDoc}
     */
    @Override
    public void launch(final ILaunchConfiguration configuration, 
                       String mode, 
                       ILaunch launch, 
                       IProgressMonitor monitor) throws CoreException {
       SEDMemoryDebugTarget target = new SEDMemoryDebugTarget(launch);
       target.setName("Fixed Example Target");
       target.setModelIdentifier(MODEL_IDENTIFIER);
       launch.addDebugTarget(target);
       
       SEDMemoryThread thread = new SEDMemoryThread(target);
       thread.setName("Fixed Example Thread");
       target.addSymbolicThread(thread);
       
       SEDMemoryStatement s1 = new SEDMemoryStatement(target, thread, thread);
       s1.setName("int x = 1;");
       thread.addChild(s1);
       
       SEDMemoryLoopNode ln = new SEDMemoryLoopNode(target, s1, thread);
       ln.setName("while (x == 1)");
       s1.addChild(ln);
       
       SEDMemoryLoopCondition lc = new SEDMemoryLoopCondition(target, ln, thread);
       lc.setName("x == 1");
       ln.addChild(lc);
       
       SEDMemoryStatement ls = new SEDMemoryStatement(target, lc, thread);
       ls.setName("x++;");
       lc.addChild(ls);
       
       SEDMemoryStatement s2 = new SEDMemoryStatement(target, ls, thread);
       s2.setName("int y = 2;");
       ls.addChild(s2);
       
       SEDMemoryStatement s3 = new SEDMemoryStatement(target, s2, thread);
       s3.setName("int result = (x + y) / z;");
       s2.addChild(s3);
       
       SEDMemoryBranchCondition bzero = new SEDMemoryBranchCondition(target, s3, thread);
       bzero.setName("z == 0");
       s3.addChild(bzero);
       
       SEDMemoryExceptionalTermination et = new SEDMemoryExceptionalTermination(target, bzero, thread);
       et.setName("throws DivisionByZeroException()");
       bzero.addChild(et);
       
       SEDMemoryBranchCondition bnotzero = new SEDMemoryBranchCondition(target, s3, thread);
       bnotzero.setName("z != 0");
       s3.addChild(bnotzero);

       SEDMemoryMethodCall call = new SEDMemoryMethodCall(target, bnotzero, thread);
       call.setName("foo(result)");
       bnotzero.addChild(call);       

       SEDMemoryBranchNode branch = new SEDMemoryBranchNode(target, call, thread);
       branch.setName("if (result >= 0)");
       call.addChild(branch);
       
       SEDMemoryBranchCondition bnegative = new SEDMemoryBranchCondition(target, branch, thread);
       bnegative.setName("result < 0");
       branch.addChild(bnegative);
       
       SEDMemoryMethodReturn returnNegative = new SEDMemoryMethodReturn(target, bnegative, thread);
       returnNegative.setName("return -1");
       bnegative.addChild(returnNegative);
       
       SEDMemoryTermination terminationNegative = new SEDMemoryTermination(target, returnNegative, thread);
       terminationNegative.setName("<end>");
       returnNegative.addChild(terminationNegative);
       
       SEDMemoryBranchCondition bpositive = new SEDMemoryBranchCondition(target, branch, thread);
       bpositive.setName("result >= 0");
       branch.addChild(bpositive);
       
       SEDMemoryMethodReturn returnPositive = new SEDMemoryMethodReturn(target, bpositive, thread);
       returnPositive.setName("return 1");
       bpositive.addChild(returnPositive);
       
       SEDMemoryTermination terminationPositive = new SEDMemoryTermination(target, returnPositive, thread);
       terminationPositive.setName("<end>");
       returnPositive.addChild(terminationPositive);
    }
}