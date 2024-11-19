import com.example.pokeInfo.configureCoroutineAndroid
import com.example.pokeInfo.configureHiltAndroid
import com.example.pokeInfo.configureKotest
import com.example.pokeInfo.configureKotlinAndroid

plugins {
    id("com.android.library")
    id("droidknights.verify.detekt")
}

configureKotlinAndroid()
configureKotest()
configureCoroutineAndroid()
configureHiltAndroid()
