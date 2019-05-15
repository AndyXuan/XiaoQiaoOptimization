package com.bigkoo.pickerview;



/**
 * Created by 2017JuFan-Android on 2017/7/5.
 */

public class PopUpUtil {

//
//
//    /**
//     * 底部滚轮点击事件回调
//     */
//    public interface OnWheelViewClick {
//        void onFirstClick(int index);
//
//        void onSecondClick(int index1, int index2);
//    }
//
//    /**
//     * 弹出底部滚轮选择
//     *
//     * @param context
//     * @param list
//     * @param selectedPosition 默认 0
//     * @param click
//     */
//
//    public static OptionsPickerView pvOptions1;
//
//    public static void alertBottomWheelOption(Context context, final ArrayList<?> list, int selectedPosition, final OnWheelViewClick click) {
//        pvOptions1 = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
//            @Override
//            public void onOptionsSelect(int options1, int options2, int options3, View v) {
//                //返回的分别是三个级别的选中位置
////                String tx = options1Items.get(options1).getPickerViewText()+
////                        options2Items.get(options1).get(options2)+
////                        options3Items.get(options1).get(options2).get(options3);
//                if (click != null) {
//                    click.onFirstClick(options1);
//                }
//            }
//        })
//                .setLayoutRes(R.layout.pickerview_custom_options, new CustomListener() {
//                    @Override
//                    public void customLayout(View v) {
//
//                        ((WheelView) v.findViewById(R.id.options1)).setOnItemSelectedListener(new OnItemSelectedListener() {
//                            @Override
//                            public void onItemSelected(int index) {
//                                pvOptions1.returnData();
//                            }
//                        });
//                    }
//                })
//                .setContentTextSize(22)//设置滚轮文字大小
//                .setSelectOptions(selectedPosition)
//                .isDialog(false)
//                .setOutSideCancelable(true)
//                .setBackgroundId(0x000000)
//                .build();
//
//
//        pvOptions1.setPicker(list);//一级选择器
//        //     pvOptions.setPicker(options1Items, options2Items);
//        //   pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器
//        pvOptions1.show();
//    }
//
//    private static OptionsPickerView pvOptions2 = null;
//    private static int indexOne = 0;
//    private static int indexTwo = 0;
//    public static void alertBottomWheelOption(Context context, final ArrayList<?> list1, final ArrayList<?> list2, int selectedPosition1, int selectedPosition2, final OnWheelViewClick click) {
//        pvOptions2 = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
//            @Override
//            public void onOptionsSelect(int options1, int options2, int options3, View v) {
//                //返回的分别是三个级别的选中位置
////                String tx = options1Items.get(options1).getPickerViewText()+
////                        options2Items.get(options1).get(options2)+
////                        options3Items.get(options1).get(options2).get(options3);
//                if (click != null) {
//                    click.onSecondClick(options1, options2);
//                }
//            }
//        })
//                .setLayoutRes(R.layout.pickerview_custom_options, new CustomListener() {
//                    @Override
//                    public void customLayout(View v) {
//
//                        ((WheelView) v.findViewById(R.id.options2)).setOnItemSelectedListener(new OnItemSelectedListener() {
//                            @Override
//                            public void onItemSelected(int index) {
//                                indexTwo = index;
//                                pvOptions2.returnData();
//                            }
//                        });
//
//
//                        ((WheelView) v.findViewById(R.id.options1)).setOnWheelSelectedListener(new OnWheelSelectedListener() {
//                            @Override
//                            public void getSelectedPosition(int index1, int index2) {
//                                indexOne = index1;
//                                indexTwo = index2;
//                                LogUtil.d("xdxddxdd---",indexOne+",,,"+indexTwo);
//                                pvOptions2.returnData();
//                            }
//                        });
//
//                    }
//                })
//                .setContentTextSize(22)//设置滚轮文字大小
//                .setSelectOptions(selectedPosition1, selectedPosition2)
//                .isDialog(false)
//                .setOutSideCancelable(true)
//                .setBackgroundId(0x000000)
//                .build();
//        indexOne = selectedPosition1;
//        indexTwo = selectedPosition2;
//        pvOptions2.setPicker(list1, list2,null);
//        pvOptions2.show();
//    }
//
//
//
//    public static OptionsPickerView pvOptions3;
//
//    public static void alertOriginalBottomWheelOption(Context context, final ArrayList<?> list, int selectedPosition, final OnWheelViewClick click) {
//        pvOptions3 = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
//            @Override
//            public void onOptionsSelect(int options1, int options2, int options3, View v) {
//                if (click != null) {
//                    click.onFirstClick(options1);
//                }
//            }
//        })
//                .setContentTextSize(22)//设置滚轮文字大小
//                .setSubmitColor(ContextCompat.getColor(context,R.color.color_ff7697))//确定按钮文字颜色
//                .setCancelColor(ContextCompat.getColor(context,R.color.color_999999))//取消按钮文字颜色
//                .setSelectOptions(selectedPosition)
//                .isDialog(false)
//                .setOutSideCancelable(true)
//                .setBackgroundId(0x000000)
//                .build();
//
//
//        pvOptions3.setPicker(list);//一级选择器
//        //     pvOptions.setPicker(options1Items, options2Items);
//        //   pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器
//        pvOptions3.show();
//    }
}
