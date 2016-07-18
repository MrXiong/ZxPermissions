package com.zx.permissions;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements
        EasyPermissions.PermissionCallbacks{

    private static final int RC_CALENDAR = 111;
    private static final int RC_CAMERA = 222;
    private static final int RC_CONTACTS = 333;
    private static final int RC_LOCATION = 444;
    private static final int RC_MICROPHONE = 555;
    private static final int RC_PHONE = 666;
    private static final int RC_SENSORS = 777;
    private static final int RC_SMS = 888;
    private static final int RC_STORAGE = 999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void requestPermissions(String success,String whyRequest,int code,String... permissions){
        if (EasyPermissions.hasPermissions(this, permissions)) {
            Toast.makeText(this, success, Toast.LENGTH_LONG).show();
        } else {
            EasyPermissions.requestPermissions(this, whyRequest,
                    code,permissions);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    public void calendar(View v){
        requestPermissions("日历权限请求成功","Zx需要获得日历权限",RC_CALENDAR,Manifest.permission.READ_CALENDAR);
    }
    public void camera(View v){
        requestPermissions("相机权限请求成功","Zx需要获得相机权限",RC_CAMERA,Manifest.permission.CAMERA);
    }
    public void contacts(View v){
        requestPermissions("电话权限请求成功","Zx需要获得电话权限",RC_CONTACTS,Manifest.permission.READ_CONTACTS);
    }
    public void location(View v){
        requestPermissions("位置权限请求成功","Zx需要获得位置权限",RC_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION);
    }
    public void microphone(View v){
        requestPermissions("麦克风权限请求成功","Zx需要获得麦克风权限",RC_MICROPHONE,Manifest.permission.RECORD_AUDIO);
    }
    public void phone(View v){
        requestPermissions("拨打电话权限请求成功","Zx需要获得拨打电话权限",RC_PHONE,Manifest.permission.CALL_PHONE);
    }
    public void sensors(View v){
        requestPermissions("传感器权限请求成功","Zx需要获得传感器权限",RC_SENSORS,Manifest.permission.BODY_SENSORS);
    }
    public void sms(View v){
        requestPermissions("短信权限请求成功","Zx需要获得短信权限",RC_SMS,Manifest.permission.SEND_SMS);
    }
    public void storage(View v){
        requestPermissions("存储空间权限请求成功","Zx需要获得存储空间权限",RC_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }
}
