package com.example.exceptions;

import com.example.util.print.Print;

class DynamicFiledsException extends Exception {}
public class DynamicFields {
    private Object[][] fields;
    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            // 期初看这个代码的时候，有点迷糊，但是后来反应过来，这就是new一个对象。
            // 的确有一点绕！
            fields[i] = new Object[] {null, null};
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0])
                    .append(":")
                    .append(obj[1])
                    .append("\n");
        }

        return result.toString();
    }

    // 这种查询方式，一举两得啊！
    private int hadField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (id.equals(fields[i][0])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 异常的使用方式
     * @param id
     * @return
     * @throws NoSuchFieldException
     */
    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hadField(id);
        if (-1 == fieldNum) {
            throw  new NoSuchFieldError();
        }
        return fieldNum;
    }

    private int makeField(String id) {
        for (int i = 0; i < fields.length; i ++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }

        // 没有空的，那就加一个
        Object[][] tmp = new Object[fields.length][2];
        for (int i = 0; i < fields.length; i++) {
            tmp[i] = fields[i];
        }

        for (int i = fields.length; i < tmp.length; i++) {
            tmp[i] = new Object[] {null, null};
        }

        fields = tmp;

        return makeField(id);
    }

    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setFiled(String id, Object value) throws DynamicFiledsException {
        if (null == value) {
            DynamicFiledsException dfe = new DynamicFiledsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hadField(id);
        if (-1 == fieldNumber) {
            fieldNumber = makeField(id);
        }

        Object result = null;
        try {
            result = getField(id);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        fields[fieldNumber][1] = value;
        return result;
    }


    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        Print.print(df);

        try {
            df.setFiled("d", "A value for d");
            df.setFiled("number", 47);
            df.setFiled("number2", 48);
            Print.print(df);

            df.setFiled("d", "A new value for d");
            df.setFiled("number3", 11);
//            Print.print();
        } catch (DynamicFiledsException e) {

        }
    }
}
