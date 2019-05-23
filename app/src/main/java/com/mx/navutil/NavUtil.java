package com.mx.navutil;

import android.app.Activity;
import android.content.Intent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 2019-03-13
 * 灵，ZWQ 建立 1.0.0版 安卓路由方便自己使用
 * 梦辛工作室
 */
public class NavUtil {

    private static Activity prevActivity;  //上一个activity
    private static Stack<Activity> activityStack = new Stack<Activity>();
    private static NavUtil instance;

    private  NavUtil(){

    }
    public static NavUtil getInstance(){
        if (instance == null){
            instance = new NavUtil();
        }
        return instance;
    }

    public static NavUtil getInstance(Activity activity){
        activityStack.push(activity);
        if (instance == null){
            instance = new NavUtil();
        }
        return instance;
    }

    public void onCreate(Activity activity){
        activityStack.push(activity);
    }


    public void onDestory(Activity activity){
        if (activityStack.contains(activity)){
            activityStack.remove(activity);
            if (!activity.isFinishing())activity.finish();
        }
    }
    /**
     * 保留当前页面，跳转到应用内的某个页面
     * @param ClassName  去某个页面的class
     * @return 是否成功
     */
    public boolean navTo(Class ClassName){
        if (activityStack.empty()){
            return false;
        }
        Intent intent = new Intent(activityStack.peek(),ClassName);
        activityStack.peek().startActivity(intent);
        return true;
    }
    /**
     * 保留当前页面，跳转到应用内的某个页面
     * @param ClassName  去某个页面的class
     * @return 是否成功
     * @param data  intent需要携带的参数
     */
    public boolean navTo(Class ClassName, HashMap<String,String> data){
        if (activityStack.empty()){
            return false;
        }
        Intent intent = new Intent(activityStack.peek(),ClassName);
        Set<Map.Entry<String,String>> entrySet = data.entrySet();
        for (Map.Entry<String,String> entery:entrySet){
            intent.putExtra(entery.getKey(),entery.getValue());
        }
        activityStack.peek().startActivity(intent);
        return true;
    }
    /**
     * 关闭当前页面，返回上一页面
     * @return 是否成功
     */
    public boolean navBack(){
        if (activityStack.empty()){
            return false;
        }
        prevActivity = activityStack.pop();
        prevActivity.finish();
        return true;
    }
    /**
     * 关闭当前页面，跳转到应用内的某个页面
     * @param className  去某个页面的class
     * @return 是否成功
     */
    public boolean redirectTo(Class className){
        if (activityStack.empty()){
            return false;
        }
        prevActivity = activityStack.pop();
        Intent intent = new Intent(prevActivity,className);
        prevActivity.startActivity(intent);
        prevActivity.finish();
        return true;
    }
    /**
     * 关闭当前页面，跳转到应用内的某个页面
     * @param className  去某个页面的class
     * @return 是否成功
     * @param data  intent需要携带的参数
     */
    public boolean redirectTo(Class className, HashMap<String,String> data){
        if (activityStack.empty()){
            return false;
        }
        prevActivity = activityStack.pop();
        Intent intent = new Intent(prevActivity,className);
        Set<Map.Entry<String,String>> entrySet = data.entrySet();
        for (Map.Entry<String,String> entery:entrySet){
            intent.putExtra(entery.getKey(),entery.getValue());
        }
        prevActivity.startActivity(intent);
        prevActivity.finish();
        return true;
    }

    /**
     * 关闭所有页面，打开到应用内的某个页面
     * @param className  去某个页面的class
     * @return 是否成功
     */
    public boolean reLaunch(Class className){
        if (activityStack.empty()){
            return false;
        }
        Intent intent = new Intent(activityStack.peek(),className);
        activityStack.peek().startActivity(intent);
        for (Activity activity:activityStack){
            activity.finish();
        }
        activityStack.clear();
        return true;
    }
    /**
     * 关闭所有页面，打开到应用内的某个页面
     * @param className  去某个页面的class
     * @return 是否成功
     * @param data  intent需要携带的参数
     */
    public boolean reLaunch(Class className, HashMap<String,String> data){
        if (activityStack.empty()){
            return false;
        }
        Intent intent = new Intent(activityStack.peek(),className);
        Set<Map.Entry<String,String>> entrySet = data.entrySet();
        for (Map.Entry<String,String> entery:entrySet){
            intent.putExtra(entery.getKey(),entery.getValue());
        }
        activityStack.peek().startActivity(intent);
        for (Activity activity:activityStack){
            activity.finish();
        }
        activityStack.clear();
        return true;
    }

}
