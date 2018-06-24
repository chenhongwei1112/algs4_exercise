package edu.princeton.cs.algs4;

import javax.swing.text.StyledEditorKit.BoldAction;

public class KuoHaoPipei<Item> {
    public static void main(String[] args) {
        ResizingArrayStack<String> s = new ResizingArrayStack<String>(2);
        boolean ok = true;
        while (!StdIn.isEmpty()) {
            String new_item = StdIn.readString();
            if (new_item.equals("{") || new_item.equals("[") || new_item.equals("(") ) {
                s.push(new_item);
            }else if (new_item.equals("}") || new_item.equals("]") || new_item.equals(")") ) {
                String pop_item = s.pop();
                if (pop_item.equals("{") && new_item.equals("}")) {
                    continue;
                }else if (pop_item.equals("[") && new_item.equals("]")) {
                    continue;
                }else if (pop_item.equals("(") && new_item.equals(")")) {
                    continue;
                }

                ok = false;
                break;
            }
        }

        if (!s.isEmpty()) {
            ok = false;
        }

        StdOut.println("AAAAAAAAAAAAAAAAAA " + ok);
    }
}
