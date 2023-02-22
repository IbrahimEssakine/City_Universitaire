package com.example.myapplication;

public class Variables_Globales {
    private  static Variables_Globales instance;

    private  static  String  _gender ="";
    private  static  String  _email="";
    private  static  String _phone ="";
    private  static  String  _name ="";
    private  static  String  _last_name ="";
    private  static  Integer _solde =0;
    private  static  String _hex_id ="";
    private  static  String  _msg ="";

    public String get_email() {
        return _email;
    }
    public  void set_email(String _email) {
        Variables_Globales._email = _email;
    }

    public String get_gender() {
        return _gender;
    }
    public  void set_gender(String _gender) {
        Variables_Globales._gender = _gender;
    }

    public String get_phone() {
        return _phone;
    }
    public  void set_phone(String _phone) {
        Variables_Globales._phone = _phone;
    }

    public String get_name() {
        return _name;
    }
    public  void set_name(String _name) {
        Variables_Globales._name = _name;
    }

    public String get_last_name() {
        return _last_name;
    }
    public  void set_last_name(String _last_name) {
        Variables_Globales._last_name = _last_name;
    }

    public Integer get_solde() {
        return _solde;
    }
    public  void set_solde(Integer _solde) {
        Variables_Globales._solde = _solde;
    }

    public String _hex_id() {
        return _hex_id;
    }
    public  void set_hex_id(String _hex_id) {
        Variables_Globales._hex_id = _hex_id;
    }

    public String get_msg() {
        return _msg;
    }
    public  void set_msg(String _msg) {
        Variables_Globales._msg = _msg;
    }




    public static synchronized Variables_Globales getInstance() {
        if (instance == null) {
            instance = new Variables_Globales();
        }
        return instance;
    }
}
