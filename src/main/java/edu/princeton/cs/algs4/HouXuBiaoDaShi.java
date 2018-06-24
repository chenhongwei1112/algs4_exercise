package edu.princeton.cs.algs4;

public class HouXuBiaoDaShi<Item> {
    public static void main(String[] args) {
        LinkedStack<String> opt_fuhao = new LinkedStack<String>();
        LinkedStack<String> opt_data = new LinkedStack<String>();

        while (!StdIn.isEmpty()) {
            String new_item = StdIn.readString();
            if (new_item.equals("+") 
             || new_item.equals("-") 
             || new_item.equals("*") 
             || new_item.equals("/")) {
                opt_fuhao.push(new_item);
            } else if (new_item.equals(")")) {
                String item_right = opt_data.pop();
                String item_left = opt_data.pop();
                String item_fuhao = opt_fuhao.pop();
                String result = item_left + " " + item_right + " " + item_fuhao;
                opt_data.push(result);
            } else if (new_item.equals("(")) {
            } else {
                opt_data.push(new_item);
            }
        }

        String result = opt_data.pop();
        StdOut.println("AAAAAAAAAAAAAAAAAA " + result);
    }
}
