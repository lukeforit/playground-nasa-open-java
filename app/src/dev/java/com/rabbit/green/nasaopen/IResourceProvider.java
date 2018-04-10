package com.rabbit.green.nasaopen;

import android.support.annotation.RawRes;

public interface IResourceProvider {
    String getJsonResource(@RawRes int id);
}
