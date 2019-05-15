package me.xdd.self.basemodule.pickview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import com.bigkoo.pickerview.OptionsPickerView;

import java.util.List;

import me.xdd.self.basemodule.pickview.bean.ItemBean;

/**
 * @author xuandong on 2019/5/15
 */
public class ChooseItemPicker {

    /**
     * 不联动的3级选择器
     * @param context
     * @param options1Items
     * @param options2Items
     * @param options3Items
     * @return
     */
    public OptionsPickerView initNoLinkOptionsPicker(Context context, final List<ItemBean> options1Items,
                                        final List<ItemBean> options2Items,
                                        final List<ItemBean> options3Items){
        OptionsPickerView optionsPickerView = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                if (v instanceof Button){
                    ((Button) v).setText(options1Items.get(options1).getPickerViewText()+options2Items.get(options2).getPickerViewText()+options3Items.get(options3).getPickerViewText());
                }
            }
        }).setCancelText("取消").setSubmitText("确定").setContentTextSize(21).build();
        optionsPickerView.setNPicker(options1Items,options2Items,options3Items);
        return optionsPickerView;
    }

    /**
     * 三级联动
     * @param context
     * @param title
     * @param options1Items
     * @param options2Items
     * @param options3Items
     * @return
     */
    public OptionsPickerView initOptionsPickerView(Context context ,String title,final List<ItemBean> options1Items,
                                                   final List<List<ItemBean>> options2Items,
                                                   final List<List<List<ItemBean>>> options3Items ){

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String tx = "";
                //返回的分别是三个级别的选中位置
                if (options1Items != null && options1Items.size()>0){
                    tx = options1Items.get(options1).getPickerViewText();
                }
                if ((options1Items != null && options1Items.size()>0) && (options2Items != null && options2Items.size()>0)){
                    tx = options1Items.get(options1).getPickerViewText()
                            + options2Items.get(options1).get(options2).getPickerViewText();

                }
                if ((options1Items != null && options1Items.size()>0) && (options2Items != null && options2Items.size()>0)&& (options3Items != null && options3Items.size()>0)){
                    tx = options1Items.get(options1).getPickerViewText()
                            + options2Items.get(options1).get(options2).getPickerViewText()
                            + options3Items.get(options1).get(options2).get(options3).getPickerViewText();

                }

                ((Button) v).setText(tx);
            }
        })
                .setTitleText(title)
                .setContentTextSize(21)//设置滚轮文字大小
                .setDividerColor(Color.GREEN)//设置分割线的颜色
                .setBgColor(Color.BLACK)
                .setTitleBgColor(Color.DKGRAY)
                .setTitleColor(Color.LTGRAY)
                .setCancelColor(Color.YELLOW)
                .setSubmitColor(Color.YELLOW)
                .setTextColorCenter(Color.LTGRAY)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                //.setLabels("省", "市", "区")
                .setBackgroundId(0x66000000) //设置外部遮罩颜色
                .build();

        if (options1Items != null && options1Items.size()>0){
            pvOptions.setSelectOptions(0);
            pvOptions.setPicker(options1Items);//一级选择器
        }
        if ((options1Items != null && options1Items.size()>0) && (options2Items != null && options2Items.size()>0)){
            pvOptions.setSelectOptions(0,0);
            pvOptions.setPicker(options1Items, options2Items);//二级选择器
        }
        if ((options1Items != null && options1Items.size()>0) && (options2Items != null && options2Items.size()>0)&& (options3Items != null && options3Items.size()>0)){
            pvOptions.setSelectOptions(0,0,0);
            pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器
        }

        return pvOptions;

    }


}
