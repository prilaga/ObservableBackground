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

# License

    Copyright 2017-2024 Prilaga

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
