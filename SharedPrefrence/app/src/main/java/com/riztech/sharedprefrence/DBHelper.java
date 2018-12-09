package com.riztech.sharedprefrence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "employee_db";
    private static final int DB_VERSION = 1;

    private static final String EMPLOYEE_TABLE = "employee";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SALARY = "salary";
    private static final String DESIGNATION = "designation";
    private static final String ADDRESS = "address";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableQuery = "create table " + EMPLOYEE_TABLE + " ( " + ID + " integer primary key autoincrement, " +
                NAME + " text, " + DESIGNATION + " text, " + SALARY + " double, " + ADDRESS + " text )";
        sqLiteDatabase.execSQL(tableQuery);
    }

    public boolean insertImployee(Employee employee) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, employee.getName());
        cv.put(DESIGNATION, employee.getDestination());
        cv.put(SALARY, employee.getSalary());
        cv.put(ADDRESS, employee.getAddress());
        long records = db.insert(EMPLOYEE_TABLE, null, cv);

        return records != 0;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String query = "select * from " + EMPLOYEE_TABLE;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(NAME));
            String address = cursor.getString(cursor.getColumnIndex(ADDRESS));
            String designation = cursor.getString(cursor.getColumnIndex(DESIGNATION));
            int id = cursor.getInt(cursor.getColumnIndex(ID));
            long salary = cursor.getLong(cursor.getColumnIndex(SALARY));

            Employee employee = new Employee(name, designation, salary, address);
            employee.setId(id);
            employeeList.add(employee);
        }
        cursor.close();
        return employeeList;
    }

    public void updateEmployee(Employee employee){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, employee.getName());
        contentValues.put(ADDRESS, employee.getAddress());
        contentValues.put(SALARY, employee.getSalary());
        contentValues.put(DESIGNATION, employee.getDestination());

        sqLiteDatabase.update(EMPLOYEE_TABLE,contentValues, ID + " = " + employee, null);


    }

    public boolean deleteEmployee(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        long rows = sqLiteDatabase.delete(EMPLOYEE_TABLE, ID + " = " + id, null);

        return rows > 0;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
