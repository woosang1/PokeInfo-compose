package com.example.detail.about

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.component.PKText
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.model.ui.AboutModel
import com.example.utils.log.DebugLog

@Composable
fun AboutRoute(
    model: AboutModel?
) {
    DebugLog("- AboutRoute -")
    AboutScreen(
        model = model
    )
}

@Composable
fun AboutScreen(
    model: AboutModel?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.white)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        if (model != null) {
            Column(
                modifier = Modifier
            ) {
                PKText(
                    text = model.description,
                    modifier = Modifier.padding(bottom = 16.dp),
                    style = LocalTypography.current.body1,
                    color = LocalColors.current.black,
                    textAlign = TextAlign.Start
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(vertical = 8.dp)
                        .background(
                            LocalColors.current.gray.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    VerticalText(label = "Height", value = "${model.height} m")
                    VerticalText(label = "Weight", value = "${model.weight} kg")
                }

                PKText(
                    modifier = Modifier
                        .padding(top = 24.dp, bottom = 12.dp),
                    text = "Breeding",
                    style = LocalTypography.current.headline2,
                    color = LocalColors.current.black,
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    HorizontalText(
                        modifier = Modifier
                            .padding(vertical = 6.dp),
                        label = "Gender Ratio",
                        value = "${model.genderRate.first}% ♂ / ${model.genderRate.second}% ♀"
                    )
                    HorizontalText(
                        modifier = Modifier
                            .padding(vertical = 6.dp), 
                        label = "Egg Groups", 
                        value = model.eddGroups
                    )
                    HorizontalText(
                        modifier = Modifier
                            .padding(vertical = 6.dp),
                        label = "Egg Cycle",
                        value = model.eggCycle.toString()
                    )
                }
            }
        }
    }
}

@Composable
fun VerticalText(label: String, value: String) {
    Column(
        modifier = Modifier.padding(horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PKText(
            text = label,
            style = LocalTypography.current.caption1,
            color = LocalColors.current.darkGray,
            textAlign = TextAlign.Center
        )
        PKText(
            text = value,
            style = LocalTypography.current.headline3,
            color = LocalColors.current.black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun HorizontalText(
    modifier: Modifier,
    label: String,
    value: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        PKText(
            text = label,
            style = LocalTypography.current.body1,
            color = LocalColors.current.darkGray,
            textAlign = TextAlign.Start
        )
        PKText(
            text = value,
            style = LocalTypography.current.body1,
            color = LocalColors.current.black,
            textAlign = TextAlign.End
        )
    }
}