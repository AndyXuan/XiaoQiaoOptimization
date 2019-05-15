package me.xdd.self.basemodule.pickview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;

import java.util.Calendar;
import java.util.Date;

import me.xdd.self.basemodule.utils.TimeUtils;

/**
 * @author xuandong on 2019/5/15
 */
public class ChooseTimePicker {
    public static final int ALL = 1;  //显示年月日时分秒
    public static final int YEAR_MONTH_DAY = 2; //年月日
    public static final int YEAR_MONTH_DAY_H_M = 3; //显示年月日时分
    public static final int H_M = 4;  //时分

    /**
     * 时间
     *
     * @param context    上下文内容
     * @param title      标题
     * @param startYear  开始年
     * @param startMonth 开始月   0- 11
     * @param startDay   开始天
     * @param endYear    结束年
     * @param endMonth   结束月
     * @param endDay     结束天
     * @param showType   显示类型
     * @return
     */
    public TimePickerView initTimePicker(Context context, String title,int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay, int showType) {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(startYear, startMonth, startDay);
        Calendar endDate = Calendar.getInstance();
        endDate.set(endYear, endMonth, endDay);
        boolean[] type = null;
        String timeType = TimeUtils.YEAR_MONTH_DAY_HOUR_MINUTE;
        switch (showType){
            case ALL:
                type = new boolean[]{true, true, true, true, true, true};
                timeType = TimeUtils.ALL;
                break;
            case YEAR_MONTH_DAY:
                type = new boolean[]{true, true, true, false, false, false};
                timeType = TimeUtils.YEAR_MONTH_DAY;
                break;
            case YEAR_MONTH_DAY_H_M:
                type = new boolean[]{true, true, true, true, true, false};
                timeType = TimeUtils.YEAR_MONTH_DAY_HOUR_MINUTE;
                break;
            case H_M:
                type = new boolean[]{false, false, false, true, true, false};
                timeType = TimeUtils.HOUR_MINUTE;
                break;

        }
        //时间选择器
        final String finalTimeType = timeType;
        //时间选择器
        TimePickerView pvTime = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null

                /*btn_Time.setText(getTime(date));*/
                if(v instanceof Button){
                    Button btn = (Button) v;
                    btn.setText(TimeUtils.dateToTime(date, finalTimeType));
                }

            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(type)
                .setLabel("年", "月", "日", "时", "分", "秒")
                .isCenterLabel(false)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setBackgroundId(0x00FFFFFF) //设置外部遮罩颜色
                .setCancelText("取消")
                .setSubmitText("确定")
                .setTitleText(title)
                .isCyclic(false)
                .setDecorView(null)
                .build();

        return pvTime;
    }


    /**
     * 自定义时间选择器
     * @param context
     * @param resLayout     自定义时间控件 UI
     * @param startYear
     * @param startMonth
     * @param startDay
     * @param endYear
     * @param endMonth
     * @param endDay
     * @param showType
     * @param onCustomViewShowInterface     回调  UI->View
     * @return
     */
    public TimePickerView initCustomTimePicker(Context context, int resLayout, int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay, int showType, final OnCustomViewShowInterface onCustomViewShowInterface) {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(startYear, startMonth, startDay);
        Calendar endDate = Calendar.getInstance();
        endDate.set(endYear, endMonth, endDay);
        boolean[] type = null;
        String timeType = TimeUtils.YEAR_MONTH_DAY_HOUR_MINUTE;
        switch (showType){
            case ALL:
                type = new boolean[]{true, true, true, true, true, true};
                timeType = TimeUtils.ALL;
                break;
            case YEAR_MONTH_DAY:
                type = new boolean[]{true, true, true, false, false, false};
                timeType = TimeUtils.YEAR_MONTH_DAY;
                break;
            case YEAR_MONTH_DAY_H_M:
                type = new boolean[]{true, true, true, true, true, false};
                timeType = TimeUtils.YEAR_MONTH_DAY_HOUR_MINUTE;
                break;
            case H_M:
                type = new boolean[]{false, false, false, true, true, false};
                timeType = TimeUtils.HOUR_MINUTE;
                break;

        }
        //时间选择器
        final String finalTimeType = timeType;
        TimePickerView pvTime = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null

                /*btn_Time.setText(getTime(date));*/
                if(v instanceof Button){
                    Button btn = (Button) v;
                    btn.setText(TimeUtils.dateToTime(date, finalTimeType));
                }

            }
        }).setLayoutRes(resLayout, new CustomListener() {

            @Override
            public void customLayout(View v) {
                if (onCustomViewShowInterface !=null){
                    onCustomViewShowInterface.showView(v);
                }
            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(type)
                .setLabel("年", "月", "日", "时", "分", "秒")
                .isCenterLabel(false)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setBackgroundId(0x00FFFFFF) //设置外部遮罩颜色
                .isCyclic(false)
                .setOutSideCancelable(true)
                .setDecorView(null)
                .build();

        return pvTime;
    }


    /**
     *
     * 当前时间的前后几天
     * @param agoDay
     * @param afterDay
     * @return
     */
    public TimePickerView initAfterOrAgoTime(Context context, String title,int agoDay,int afterDay,int showType){
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = TimeUtils.getAgoOrAfterCalendar(new Date(),agoDay);
        Calendar endDate = TimeUtils.getAgoOrAfterCalendar(new Date(),afterDay);
        boolean[] type = null;
        String timeType = TimeUtils.YEAR_MONTH_DAY_HOUR_MINUTE;
        switch (showType){
            case ALL:
                type = new boolean[]{true, true, true, true, true, true};
                timeType = TimeUtils.ALL;
                break;
            case YEAR_MONTH_DAY:
                type = new boolean[]{true, true, true, false, false, false};
                timeType = TimeUtils.YEAR_MONTH_DAY;
                break;
            case YEAR_MONTH_DAY_H_M:
                type = new boolean[]{true, true, true, true, true, false};
                timeType = TimeUtils.YEAR_MONTH_DAY_HOUR_MINUTE;
                break;
            case H_M:
                type = new boolean[]{false, false, false, true, true, false};
                timeType = TimeUtils.HOUR_MINUTE;
                break;

        }
        //时间选择器
        final String finalTimeType = timeType;
        //时间选择器
        TimePickerView pvTime = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null

                /*btn_Time.setText(getTime(date));*/
                if(v instanceof Button){
                    Button btn = (Button) v;
                    btn.setText(TimeUtils.dateToTime(date, finalTimeType));
                }

            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(type)
                .setLabel("年", "月", "日", "时", "分", "秒")
                .isCenterLabel(false)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setBackgroundId(0x00FFFFFF) //设置外部遮罩颜色
                .setCancelText("取消")
                .setSubmitText("确定")
                .setTitleText(title)
                .isCyclic(false)
                .setDecorView(null)
                .build();

        return pvTime;
    }


}
