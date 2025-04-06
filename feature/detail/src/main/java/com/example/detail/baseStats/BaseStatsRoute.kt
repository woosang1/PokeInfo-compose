package com.example.detail.baseStats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
            .background(LocalColors.current.white)
            .padding(horizontal = 12.dp, vertical = 20.dp)
    ) {
        if (model != null) {
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                StatsBarLayout(
                    modifier = Modifier,
                    title = "HP",
                    value = model.hp,
                    maxValue = 200
                )

                StatsBarLayout(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    title = "공격",
                    value = model.attack,
                    maxValue = 200
                )

                StatsBarLayout(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    title = "방어",
                    value = model.defense,
                    maxValue = 200
                )

                StatsBarLayout(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    title = "특수공격",
                    value = model.specialAttack,
                    maxValue = 200
                )

                StatsBarLayout(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    title = "특수방어",
                    value = model.specialDefense,
                    maxValue = 200
                )

                StatsBarLayout(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    title = "스피드",
                    value = model.speed,
                    maxValue = 200
                )

                StatsBarLayout(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    title = "총점",
                    value = model.total,
                    maxValue = 1000
                )
            }
        }
    }
}

@Composable
fun StatsBarLayout(
    modifier: Modifier = Modifier,
    title: String,
    value: Int,
    maxValue: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // 이름
        Text(
            text = title,
            modifier = Modifier
                .width(80.dp),
            style = LocalTypography.current.headline3,
            color = LocalColors.current.darkGray,
            maxLines = 1,
            textAlign = TextAlign.Start
        )

        // 수치
        Text(
            text = value.toString(),
            modifier = Modifier,
            style = LocalTypography.current.headline3,
            color = LocalColors.current.black,
            maxLines = 1,
            textAlign = TextAlign.Start
        )

        // 프로그레스 바
        Box(
            modifier = Modifier
                .weight(1f)
                .height(8.dp)
                .padding(start = 16.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(LocalColors.current.gray)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(value / maxValue.toFloat())
                    .background(LocalColors.current.red)
            )
        }
    }
}
