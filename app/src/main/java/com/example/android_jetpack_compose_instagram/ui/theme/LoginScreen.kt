package com.example.android_jetpack_compose_instagram.ui.theme

import android.app.Activity
import android.graphics.Paint.Align
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.buildSpannedString
import com.example.android_jetpack_compose_instagram.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.io.StringReader

@Composable
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)) {
        InstagramHeader(Modifier.align(Alignment.TopEnd))
        InstagramBody(Modifier.align(Alignment.Center))
    }
}

@Composable
fun InstagramBody(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnable by rememberSaveable { mutableStateOf(true)}

    Column(modifier = modifier) {
        InstagramLogo(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        InstagramEmail(email) { email = it }
        Spacer(modifier = Modifier.size(4.dp))
        InstagramPassword(password) { password = it }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPasswordText(modifier = Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnable)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        SocialLogin(modifier = Modifier.align(alignment = Alignment.Start))
    }
}

@Composable
fun SocialLogin(modifier: Modifier) {
    Row(modifier = modifier
        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Image(painterResource(id = R.drawable.fb), contentDescription = "Social Media Logo", Modifier.size(16.dp))
        Text(text = stringResource(id = R.string.social_media_login), color = Color(0xFF4EA8E9), fontSize = 14.sp, fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 8.dp))
        }
    }

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(modifier = Modifier
            .height(1.dp)
            .weight(1f), color = Color.LightGray)
        Text(
            "OR",
            modifier = Modifier.padding(horizontal = 18.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        Divider(modifier = Modifier
            .height(1.dp)
            .weight(1f), color = Color.LightGray)
    }
}

@Composable
fun LoginButton(loginEnable: Boolean) {
    Button(onClick = { }, enabled = loginEnable, modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(id = R.string.login_text), fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ForgotPasswordText(modifier: Modifier) {
        Text(text = stringResource(id = R.string.forgot_password), modifier = modifier
            .clickable { },
            color = Color(0xFF4EA8E9), fontSize = 12.sp, fontWeight = FontWeight.Bold)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramPassword(password: String, onTextChanged: (String) -> Unit) {
    TextField(value = password, onValueChange = {onTextChanged(it)}, modifier = Modifier.fillMaxWidth() )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramEmail(email: String, onTextChanged: (String) -> Unit) {
    TextField(value = email, onValueChange = { onTextChanged(it) }, modifier = Modifier.fillMaxWidth())
}

@Composable
fun InstagramLogo(modifier: Modifier) {
    Image(painter = painterResource(id = R.drawable.insta), contentDescription = "logo", modifier = modifier)
}

@Composable
fun InstagramHeader(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close, contentDescription = "Close App", modifier.clickable { activity.finish() })
}