package de.uka.ilkd.key.util;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ThreadUtilities {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadUtilities.class);


    /**
     * Invoke a runnable object on the AWT event thread and wait for the execution to finish.
     *
     * If an exception occurs during the run, the trace is printed to stderr.
     *
     * @param runner Runnable capturing code to execute on the awt thread.
     */
    public static void invokeAndWait(Runnable runner) {
        if (SwingUtilities.isEventDispatchThread()) {
            runner.run();
        } else {
            try {
                SwingUtilities.invokeAndWait(runner);
            } catch (InterruptedException e) {
                LOGGER.debug("", e);
            } catch (InvocationTargetException ite) {
                Throwable targetExc = ite.getTargetException();
                LOGGER.debug("", targetExc);
                LOGGER.debug("", ite);
            }
        }
    }

    /**
     * Invoke a runnable object on the AWT event thread. Does not wait necessarily for it to finish.
     * If the current thread is already the event queue, the {@link Runnable} object is simply
     * executed.
     *
     * @param runnable Runnable capturing code to execute on the awt thread.
     */
    public static void invokeOnEventQueue(Runnable runnable) {
        if (EventQueue.isDispatchThread()) {
            runnable.run();
        } else {
            SwingUtilities.invokeLater(runnable);
        }
    }

}
