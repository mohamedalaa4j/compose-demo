package com.example.compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.R
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun LoginScreen(navController: NavHostController) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val screenHeight = getScreenHeight()
        val (topImage, loginLabel) = createRefs()

        Image(
            modifier = Modifier
                .constrainAs(topImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .height(screenHeight / 3)
                .clip(
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 20.sdp,
                        bottomEnd = 20.sdp
                    )
                ),
            painter = ColorPainter(colorResource(id = R.color.red)),
            contentDescription = "top banner"
        )

        Text(
            modifier = Modifier.constrainAs(loginLabel) {
                top.linkTo(topImage.top)
                bottom.linkTo(topImage.bottom)
                start.linkTo(topImage.start)
                end.linkTo(topImage.end)
            },
            text = "Login",
            style = TextStyle(
                fontWeight = FontWeight.W500,
                color = colorResource(id = R.color.white),
                fontSize = 24.ssp,
            )
        )
    }
}

@Composable
fun getScreenHeight(): Dp {
    val configuration = LocalConfiguration.current
    return configuration.screenHeightDp.dp
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_3A, locale = "en")
@Composable
fun Preview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}