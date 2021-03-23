package problem300To400;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a341NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int index;

    public a341NestedIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<>();
        this.index = 0;
        init(nestedList);
    }

    public void init(List<NestedInteger> nestedList) {
        nestedList.forEach(n -> {
            if (n.isInteger()) {
                list.add(n.getInteger());
            } else {
                init(n.getList());
            }
        });
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index != list.size();
    }


    interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }
}
