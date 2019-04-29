//package me.xujichang.lib.csipsimple.sherlock.menu;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.os.Parcelable;
//import android.support.v4.view.ActionProvider;
//import android.support.v7.view.menu.ActionMenuItemView;
//import android.support.v7.view.menu.BaseMenuPresenter;
//import android.support.v7.view.menu.MenuItemImpl;
//import android.support.v7.view.menu.MenuView;
//
//import me.xujichang.lib.csipsimple.R;
//
///**
// * Des:Linkage - me.xujichang.lib.csipsimple.sherlock
// *
// * @author xujichang
// * @date 2019-04-23 - 21:27
// * <p>
// * modify:
// */
//@SuppressLint("RestrictedApi")
//public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
//    public ActionMenuPresenter(Context context) {
//        super(context, R.layout.abs__action_menu_layout,
//                R.layout.abs__action_menu_item_layout);
//    }
//
//    @Override
//    public void bindItemView(MenuItemImpl menuItem, MenuView.ItemView itemView) {
//        itemView.initialize(menuItem, 0);
//        final ActionMenuView menuView = (ActionMenuView) mMenuView;
//        ActionMenuItemView actionItemView = (ActionMenuItemView) itemView;
//        actionItemView.setItemInvoker(menuView);
//    }
//
//    @Override
//    public Parcelable onSaveInstanceState() {
//        return null;
//    }
//
//    @Override
//    public void onRestoreInstanceState(Parcelable parcelable) {
//
//    }
//
//    @Override
//    public void onSubUiVisibilityChanged(boolean b) {
//
//    }
//
//    public void setReserveOverflow(boolean b) {
//
//    }
//
//    public void setWidthLimit(int widthPixels, boolean b) {
//
//    }
//
//    public void setItemLimit(int i) {
//
//    }
//}
