This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros.scripts;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.Stack;

public class ScriptTreeParser {

    public static ScriptNode parse(Reader reader) throws IOException, ScriptException {

        ScriptNode root = null;
        ScriptNode last = null;
        Stack<ScriptNode> branchStack = new Stack<>();

        ScriptLineParser lineParser = new ScriptLineParser(reader);

        while (true) {

            int from = lineParser.getPosition();
            Map<String, String> command = lineParser.parseCommand();
            int to = lineParser.getPosition();

            if (command == null) {
                return root;
            }

            switch (command.get(ScriptLineParser.COMMAND_KEY)) {
            case "branches":
                branchStack.push(last);
                break;
            case "next":
                last = branchStack.peek();
                break;
            case "end":
                last = null;
                branchStack.pop();
                break;
            default:
                ScriptNode node = new ScriptNode(last, command, from, to);
                if (root == null) {
                    root = node;
                } else if (last == null) {
                    throw new ScriptException("unexpected last");
                } else {
                    last.addNode(node);
                }
                last = node;
                break;
            }
        }

    }

    public static void main(String[] args) throws IOException, ScriptException {

        ScriptNode root =
            ScriptTreeParser.parse(new InputStreamReader(System.in));

        root.dump(0);

    }

}
