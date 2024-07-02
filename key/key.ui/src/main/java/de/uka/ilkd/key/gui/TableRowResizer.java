This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.event.MouseInputAdapter;

/**
 * A mouse listener for resizing the height of the JTable rows.
 * Taken from here:
 * https://stackoverflow.com/questions/4387995/adjusting-individual-row-height-using-cursor-on-jtable
 *
 * @author mihai
 *
 */

public class TableRowResizer extends MouseInputAdapter {
    public static Cursor resizeCursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);

    private int mouseYOffset, resizingRow;
    private Cursor otherCursor = resizeCursor;
    private JTable table;

    public TableRowResizer(JTable table) {
        this.table = table;
        table.addMouseListener(this);
        table.addMouseMotionListener(this);
    }

    private int getResizingRow(Point p) {
        return getResizingRow(p, table.rowAtPoint(p));
    }

    private int getResizingRow(Point p, int row) {
        if (row == -1) {
            return -1;
        }
        int col = table.columnAtPoint(p);
        if (col == -1) {
            return -1;
        }
        Rectangle r = table.getCellRect(row, col, true);
        r.grow(0, -3);
        if (r.contains(p)) {
            return -1;
        }

        int midPoint = r.y + r.height / 2;
        int rowIndex = (p.y < midPoint) ? row - 1 : row;

        return rowIndex;
    }

    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();

        resizingRow = getResizingRow(p);
        mouseYOffset = p.y - table.getRowHeight(resizingRow);
    }

    private void swapCursor() {
        Cursor tmp = table.getCursor();
        table.setCursor(otherCursor);
        otherCursor = tmp;
    }

    public void mouseMoved(MouseEvent e) {
        if ((getResizingRow(e.getPoint()) >= 0) != (table.getCursor() == resizeCursor)) {
            swapCursor();
        }
    }

    public void mouseDragged(MouseEvent e) {
        int mouseY = e.getY();

        if (resizingRow >= 0) {
            int newHeight = mouseY - mouseYOffset;
            if (newHeight > 0) {
                table.setRowHeight(resizingRow, newHeight);
            }
        }
    }
}
