package com.im.bitcoinexchange.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import java.text.DecimalFormat
import java.text.NumberFormat
import kotlin.math.round


@Composable
fun ExchangeCard(
    symbols: String,
    currency: String,
    rate: Double,
){

    val shape = RoundedCornerShape(100.dp)
    val textFromHtmlFormat = HtmlCompat.fromHtml(symbols, HtmlCompat.FROM_HTML_MODE_LEGACY)
    val symbol = textFromHtmlFormat


    val roundedNumber = Math.round(rate / 0.10) * 0.10

    val nf: NumberFormat = DecimalFormat("#,###.00")

    val number = nf.format(roundedNumber)

    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(12.dp)
                .background(Color.White),
        ) {
            Row(
                Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(shape = shape)
                        .background(Color(0xFF400080)),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "$symbol",
                        style = TextStyle(
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontSize = 22.sp,
                        ),
                    )
                }
                Text(
                    text = "$currency",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                    ),
                    modifier = Modifier.padding(12.dp)
                )
            }

            Column(
                Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ){

                Text(
                    text = "$number",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                    ),
                )

            }

        }
    }


}