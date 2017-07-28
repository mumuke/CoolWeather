# CoolWeather
天气，第二版

public class CoolWeatherDB {
    //    数据库名
    public static final String DB_NAME = "cool_weather";
    //    数据库版本
    public static final int VERSION = 1;
    private static CoolWeatherDB coolWeatherDB;
    private SQLiteDatabase db;

    //    构造函数的私有化
    private CoolWeatherDB(Context context) {
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }

    //获取CoolWeatherDB的实例
    public synchronized static CoolWeatherDB getInstance(Context context) {
        if (coolWeatherDB == null) {
            coolWeatherDB = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }

    //    将Province实例存储到数据库
    public void saveProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name", province.getProvinceName());
            values.put("province_code", province.getProvinceCode());
            db.insert("Province", null, values);
        }
    }

    //    从数据库里读取所有省的信息
    public List<Province> loadProvince() {
        List<Province> provinceList = new ArrayList<Province>();
        Cursor cursor = db.query("Province", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                provinceList.add(province);
           } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return provinceList;
    }

    //    将City存储到数据库里
    public void saveCity(City city) {
        if (city != null) {
            ContentValues values = new ContentValues();
           values.put("city_name", city.getCityName());            values.put("city_code", city.getCityCode());
            values.put("Province_id", city.getProvinceId());
            db.insert("City", null, values);
        }
    }

    //从数据库里读取该省下的所有城市的信息
    public List<City> loadCity(int provinceId) {
        List<City> cityList = new ArrayList<City>();
        Cursor cursor = db.query("City", null, "province_id=?", new String[]{String.valueOf(provinceId)}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setProvinceId(provinceId);
                cityList.add(city);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return cityList;
    }

    //    将County保存到数据库
    public void saveCounty(County county) {
        if (county != null) {
            ContentValues values = new ContentValues();
            values.put("county_name", county.getCountyName());
            values.put("county_code", county.getCountyCode());
            values.put("city_id", county.getCityId());
            db.insert("County", null, values);
        }
    }

   //从数据库里读取该城市的所有镇信息
   public List<County> loadCounty(int cityId) {
        List<County> countyList = new ArrayList<County>();
        Cursor cursor = db.query("County", null, "city_id =?", new String[]{String.valueOf(cityId)}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                County county = new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
                county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
                county.setCityId(cityId);
                countyList.add(county);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
       }
        return countyList;
   }
}



//创建几张表的内容
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

    /**
     * Province表建立
     */
    public static final String CREATE_PROVINCE = "create table Province ( "
            + "id integer primary key autoincrement, "
            + "province_name text, "
            + "province_code text)";

    /**
     * City表建立
     */
    public static final String CREATE_CITY = "create table City ( "
            + "id integer primary key autoincrement, "
            + "city_name text, "
            + "city_code text, "
            + "province_id integer) ";

    /**
     * County表建立
     */
    public static final String CREATE_COUNTY = "create table County ( "
            + "id integer primary key autoincrement, "
            + "county_name text, "
            + "county_code text, "
            + "city_id integer)";


    public CoolWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_COUNTY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
