# ObservableBackground

Helps to set any resources to the view.

Ability to set: int Color, @ColorRes, @DrawableRes, Drawable, Bitmap 

#### 1. CopyPaste ObservableBackground.kt to your project

#### 2. Add ObservableBackground field to your ViewModel

```Kotlin
class ViewModel {

    val background = ObservableBackground()

    fun setColor() {
        background.setColorValue(Color.WHITE)
    }
}
```    

#### 3. Set viewModel in the xml

```XML
<FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@{viewModel.background}">
```
