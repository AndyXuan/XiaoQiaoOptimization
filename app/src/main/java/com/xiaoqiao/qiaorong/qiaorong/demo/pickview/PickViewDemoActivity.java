package com.xiaoqiao.qiaorong.qiaorong.demo.pickview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.xiaoqiao.qiaorong.qiaorong.R;
import com.xiaoqiao.qiaorong.qiaorong.base.TestBaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import me.xdd.self.basemodule.base.BaseNormalTitleActivity;
import me.xdd.self.basemodule.pickview.ChooseItemPicker;
import me.xdd.self.basemodule.pickview.ChooseTimePicker;
import me.xdd.self.basemodule.pickview.OnCustomViewShowInterface;
import me.xdd.self.basemodule.pickview.bean.ItemBean;

public class PickViewDemoActivity extends TestBaseActivity {

    TimePickerView timePickerView = null;
    TimePickerView customerTimePickerView = null;
    TimePickerView afterPickerView = null;
    OptionsPickerView optionsPickerView = null;
    OptionsPickerView optionsPickerView2 = null;
    private ArrayList<ItemBean> food = new ArrayList<>();
    private ArrayList<ItemBean> clothes = new ArrayList<>();
    private ArrayList<ItemBean> computer = new ArrayList<>();

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,PickViewDemoActivity.class);
        return intent;
    }

    @Override
    protected boolean isTranslateSystemStatus() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_view_demo);

        ChooseTimePicker chooseTimePicker =new ChooseTimePicker();
        timePickerView = chooseTimePicker.initTimePicker(this,"本地时间",2000,0,1,2050,11,28,ChooseTimePicker.H_M);
        customerTimePickerView = chooseTimePicker.initCustomTimePicker(this,R.layout.pickerview_custom_time,2000,0,1,2050,11,28,ChooseTimePicker.H_M,new OnCustomViewShowInterface(){
            @Override
            public void showView(View view) {
                TextView tv_finish = view.findViewById(R.id.tv_finish);
                tv_finish.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        customerTimePickerView.returnData();
                        customerTimePickerView.dismiss();
                    }
                });
            }
        });

        ChooseItemPicker chooseItemPicker = new ChooseItemPicker();

        ShowItemBean showItemBean1 = new ShowItemBean();
        showItemBean1.setDescription("de1");
        showItemBean1.setId("111");
        showItemBean1.setName("KFC");



        ShowItemBean showItemBean2 = new ShowItemBean();
        showItemBean2.setDescription("de2");
        showItemBean2.setId("222");
        showItemBean2.setName("MacDonald");


        ShowItemBean showItemBean3 = new ShowItemBean();
        showItemBean3.setDescription("de3");
        showItemBean3.setId("333");
        showItemBean3.setName("Pizza");
        food.add(showItemBean1);
        food.add(showItemBean2);
        food.add(showItemBean3);

        clothes.add(showItemBean2);
        clothes.add(showItemBean3);
        clothes.add(showItemBean1);

        computer.add(showItemBean3);
        computer.add(showItemBean1);
        computer.add(showItemBean2);
        computer.add(showItemBean1);
        optionsPickerView = chooseItemPicker.initNoLinkOptionsPicker(this,food,clothes,computer);


        ArrayList<ItemBean> options1Items = new ArrayList<>();
        List<List<ItemBean>> options2Items = new ArrayList<>();
        List<List<List<ItemBean>>> options3Items = new ArrayList<>();
        //选项1
        options1Items.add(new ShowItemBean("0", "广东"));
        options1Items.add(new ShowItemBean("1", "湖南"));
        options1Items.add(new ShowItemBean("2", "广西"));

        //选项2
        ArrayList<ItemBean> options2Items_01 = new ArrayList<>();
        options2Items_01.add(new ShowItemBean("0", "佛山"));
        options2Items_01.add(new ShowItemBean("0", "东莞"));
        options2Items_01.add(new ShowItemBean("0", "珠海"));
        options2Items_01.add(new ShowItemBean("0", "深圳"));

        ArrayList<ItemBean> options2Items_02 = new ArrayList<>();
        options2Items_02.add(new ShowItemBean("0", "长沙"));
        options2Items_02.add(new ShowItemBean("0", "岳阳"));
        options2Items_02.add(new ShowItemBean("0", "株洲"));
        options2Items_02.add(new ShowItemBean("0", "衡阳"));


        ArrayList<ItemBean> options2Items_03 = new ArrayList<>();
        options2Items_03.add(new ShowItemBean("0", "桂林"));
        options2Items_03.add(new ShowItemBean("0", "玉林"));


        options2Items.add(options2Items_01);
        options2Items.add(options2Items_02);
        options2Items.add(options2Items_03);
        optionsPickerView2 = chooseItemPicker.initOptionsPickerView(this,"实例",options1Items,options2Items,options3Items);
        afterPickerView = chooseTimePicker.initAfterOrAgoTime(this,"日期",-5,2,ChooseTimePicker.YEAR_MONTH_DAY);
    }

    @Override
    public void initIntentAndMemData() {
        super.initIntentAndMemData();
        hideTitleBarAndStatusBar();
        setTextTitle("选择器",R.color.colorBlack);
    }

    @Override
    public void onViewClicked(View view) {
        super.onViewClicked(view);
        switch (view.getId()){
            case R.id.btn_Time:
                timePickerView.show(view);
                break;
            case R.id.btn_Options:
                afterPickerView.show(view);
                break;
            case R.id.btn_CustomTime:
                customerTimePickerView.show(view);
                break;
            case R.id.btn_CustomOptions:
                optionsPickerView2.show(view);
                break;
            case R.id.btn_no_linkage:
                optionsPickerView.show(view);
                break;
            case R.id.btn_GotoJsonData:
                startActivity(JsonDataActivity.newIntent(this));
                break;
            case R.id.btn_fragment:
                break;


        }
    }

    public class ShowItemBean extends ItemBean{
        private String id;
        private String description;

        public ShowItemBean() {
        }

        public ShowItemBean(String id, String description) {
            this.id = id;
            this.description = description;
            super.setName(description);
        }



        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String getPickerViewText() {
            return getName();
        }
    }
}
