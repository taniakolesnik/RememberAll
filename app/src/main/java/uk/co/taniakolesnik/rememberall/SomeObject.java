package uk.co.taniakolesnik.rememberall;

import android.content.Context;

public class SomeObject {
    
    private String someField;
    private String someSubField;


    public SomeObject(String someField, String someSubField) {
        this.someField = someField;
        this.someSubField = someSubField;
    }

    public SomeObject(String someField, Context context) {
        this.someField = someField;
        this.someSubField = context.getString(R.string.subField_empty_value);
    }

    public SomeObject(Context context) {
        this.someField = context.getString(R.string.field_empty_value);
        this.someSubField = context.getString(R.string.subField_empty_value);
    }
}
