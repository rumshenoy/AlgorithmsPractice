package com.algorithmspractice.stacks;
//Given a nested list of integers, implement an iterator to flatten it.
//Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//Example 1:
//Given the list [[1,1],2,[1,1]],
//By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
//Example 2:
//Given the list [1,[4,[6]]],
//By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

import java.util.*;

class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() -1 ; i >=0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger cur = stack.peek();
            if(cur.isInteger()){
                return true;
            }else{
                List<NestedInteger> list = cur.getList();
                stack.pop();
                for(int i = list.size()-1; i >=0; i--){
                    stack.push(list.get(i));
                }
            }
        }
        return false;
    }
}

public class FlattenNestedListIterator{
    public static void main(String[] args) {
        NestedList n1 = new NestedList(3);
        NestedList n2 = new NestedList(4);
        NestedList n3 = new NestedList(5);
        NestedList n4 = new NestedList(6);
        NestedList n5 = new NestedList(new ArrayList<>(Arrays.asList(n2, n3, n4)));
        List<NestedInteger> nestedList = new ArrayList<>(Arrays.asList(n1, n5));
        NestedIterator i = new NestedIterator(nestedList);
        while (i.hasNext()){
            System.out.print(i.next() + " ");
        }
    }
}
