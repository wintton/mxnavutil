package com.mx.navutil;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import java.util.Calendar;

/**
 * 2019-03-13
 * 灵，ZWQ 建立 1.0.0版 android提示窗使用工具
 * 梦辛工作室
 */
public class DialogUtil {
    private static Context mContext;
    private  static DialogUtil instance;
    private static AlertDialog alertDialog;
    private static ProgressDialog progressDialog;
    private static DatePickerDialog datePickerDialog;
    private static TimePickerDialog timePickerDialog;

    private DialogUtil() {

    }

    public static DialogUtil getInstance(Context context) {
        mContext = context;
        if (instance == null) {
            instance = new DialogUtil();
        }
        return instance;
    }

    /**
     * 显示时间选择器
     * @param lisenter  回调
     */
    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener lisenter){
        if (mContext == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        timePickerDialog = new TimePickerDialog(mContext,lisenter,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),
                true);
        timePickerDialog.show();
    }
    /**
     * 显示时间选择器
     * @param lisenter
     * @param calendar  默认显示时间
     */
    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener lisenter, Calendar calendar){
        if (mContext == null) {
            return;
        }
        timePickerDialog = new TimePickerDialog(mContext,lisenter,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),
                true);
        timePickerDialog.show();
    }

    /**
     * 显示日期选择器
     * @param onDateSetListener
     */
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener onDateSetListener){
        if (mContext == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(mContext, DatePickerDialog.THEME_DEVICE_DEFAULT_LIGHT, onDateSetListener,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
        datePickerDialog.show();
    }
    /**
     * 显示日期选择器
     * @param onDateSetListener
     * @param calendar 默认时间
     */
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener onDateSetListener, Calendar calendar){
        if (mContext == null) {
            return;
        }
        datePickerDialog = new DatePickerDialog(mContext, DatePickerDialog.THEME_DEVICE_DEFAULT_LIGHT, onDateSetListener,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
        datePickerDialog.show();
    }
    /**
     * 显示加载型提示框
     * @param msg 提示内容
     */
    public  void showLoadding(String msg) {
        if (mContext != null){
            progressDialog = new ProgressDialog(mContext);
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    /**
     * 弹出对话提示框
     * @param title  标题
     * @param msg 内容
     */
    public  void showAlertDialogHint(String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage(msg);
        builder.setTitle(title);
        builder.setPositiveButton("知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog =  builder.create();
        alertDialog.show();
    }

    /**
     * 弹出对话提示框 ，显示带有两个按钮的提示框
     * @param title  标题
     * @param msg  提示内容
     * @param callBack 确认回调  CallBack.SUCCESS 成功回调
     */
    public  void showAlertDialog(String title, String msg, final CallBack callBack, String confirmtext, String canletext){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage(msg);
        builder.setTitle(title);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callBack.getResult(CallBack.SUCCESS);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callBack.getResult(CallBack.FAIL);
            }
        });
        alertDialog =  builder.create();
        alertDialog.show();
    }

    /**
     * 显示集合对话弹窗
     * @param title 标题
     * @param content 内容
     * @param callBack 成功回调
     */
    public  void showItemAlertDialog(String title, String[] content, DialogInterface.OnClickListener callBack){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(title);
        builder.setItems(content,callBack);
        alertDialog =  builder.create();
        alertDialog.show();
    }

    /**
     * 吐司提示
     * @param msg 提示内容
     */
    public  void showToast(String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }

    /**
     * 隐藏加载型提示框
     * @return 是否成功
     */
    public  boolean hideLoadding() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            return true;
        }
        return false;
    }
    /**
     * 隐藏对话型提示框
     * @return 是否成功
     */
    public  boolean hideAlertDialog() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
            return true;
        }
        return false;
    }
}
