package com.superc.common.widget.qmui.widget;

public interface INotchInsetConsumer {
    /**
     * @return if true stop dispatch to child view
     */
    boolean notifyInsetMaybeChanged();
}