package com.example.detail.baseStats

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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.model.ui.BaseStatsModel

@Composable
fun BaseStatsRoute(
    model: BaseStatsModel?
) {
    BaseStatsScreen(model = model)
}

@Composable
fun BaseStatsScreen(
    model: BaseStatsModel?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.lightBlue)
            .padding(horizontal = 12.dp, vertical = 20.dp)
    ) {
        if (model != null) {
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = model.description,
                    modifier = Modifier,
                    style = LocalTypography.current.headline3,
                    color = LocalColors.current.black,
                    maxLines = 1,
                    textAlign = TextAlign.Start
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(top = 20.dp, start = 16.dp, end = 16.dp)
                        .background(LocalColors.current.white)
                        .border(1.dp, LocalColors.current.gray, shape = RoundedCornerShape(4.dp)),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    VerticalText(label = "Height", value = "${model.height} m")
                    VerticalText(label = "Weight", value = "${model.weight} kg")
                }

                HorizontalDivider()

                Text(
                    modifier = Modifier
                        .padding(top = 20.dp),
                    text = "Breeding",
                    style = LocalTypography.current.headline2,
                    color = LocalColors.current.black,
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    HorizontalText(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        label = "Gender Ratio",
                        value = "${model.genderRate.first}% ♂ / ${model.genderRate.second}% ♀"
                    )
                    HorizontalText(
                        modifier = Modifier
                            .padding(top = 8.dp), label = "Egg Groups", value = model.eddGroups
                    )
                    HorizontalText(
                        modifier = Modifier
                            .padding(top = 8.dp),
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
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .weight(1f),
            text = label,
            style = LocalTypography.current.subTitle,
            color = LocalColors.current.black,
            textAlign = TextAlign.Start
        )
        Text(
            modifier = Modifier
                .weight(1f),
            text = value,
            style = LocalTypography.current.subTitle,
            color = LocalColors.current.black,
            textAlign = TextAlign.Start
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
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = label,
            style = LocalTypography.current.subTitle,
            color = LocalColors.current.black,
            textAlign = TextAlign.Start
        )
        Text(
            modifier = Modifier.weight(2f),
            text = value,
            style = LocalTypography.current.subTitle,
            color = LocalColors.current.black,
            textAlign = TextAlign.Start
        )
    }
}