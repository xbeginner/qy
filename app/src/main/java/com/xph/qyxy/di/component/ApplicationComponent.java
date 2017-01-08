/*
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.xph.qyxy.di.component;

import android.content.Context;


import com.xph.qyxy.di.module.ApplicationModule;
import com.xph.qyxy.di.scope.ContextLife;
import com.xph.qyxy.di.scope.PerApp;

import dagger.Component;

/**
 * 创建一个Compenent,提供Application的Context
 * 提供一个获取Application context的方法
 */
@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplication();

}

