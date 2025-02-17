package item;

import java.util.Arrays;

public abstract class ItemEntity {

    protected class ItemInfo {

        private int id;
        private int quantity;
        private int type;


        public String getInfo() {
            String[] info = new String[3];
            return Arrays.toString(info);
        }

    }





}
