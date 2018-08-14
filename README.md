# cocomenupicker-demo
the demo of cocomenupicker widget


# 效果如下：

1.弹框显示效果
------
![cocomenupicker](https://github.com/cozing/cocomenupicker-demo/blob/master/screenshot/demo.gif)

2.点击确认按钮
------
![cocomenupicker](https://github.com/cozing/cocomenupicker-demo/blob/master/screenshot/democonfirm.gif)

3.点击取消按钮
------
![cocomenupicker](https://github.com/cozing/cocomenupicker-demo/blob/master/screenshot/democancel.gif)


# 实现方式

1.在project下的gradle加入以下代码：
------
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

2.在mudole下的gradle加入依赖：
------
```
  dependencies {
		implementation 'com.github.cozing:cocomenupicker:v1.0.0'
	}
```

3.new一个MultiPickerView并设置相关属性配置，调用show():
----
```java
List<T> lists1 = new ArrayList<>();
List<List<T>> lists2 = new ArrayList<>();
MultiPickerView multiPickerView = new MultiPickerView(this);
multiPickerView.setDoublePicker(lists1, lists2);
multiPickerView.setOnMultiPickerSelectListener(new MultiPickerView.OnMultiPickerSelectListener() {
            @Override
            public void onSelect(int index1, int index2) {
                
            }
        });
multiPickerView.setOnMultiPickerDismissListener(new MultiPickerView.OnMultiPickerDismissListener() {
            @Override
            public void onDismiss() {
                
            }
        });
multiPickerView.show();
```


注意
----
如果需要显示的数据是自定义的结构体，需要该结构体实现MultiPickerViewEventType接口，并在重写方法getPickerViewTextFieldForShow()中返回需要显示的属性，比如：

```java
public class PickerData implements MultiPickerViewEventType {
    private String name;
    private String id;
    
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String getPickerViewTextFieldForShow() {
        return name;
    }
}
```
此时显示的数据为List<PickerData>子单位的name。


