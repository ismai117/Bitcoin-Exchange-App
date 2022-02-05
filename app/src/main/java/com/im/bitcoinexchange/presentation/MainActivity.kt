package com.im.bitcoinexchange.presentation


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.im.bitcoinexchange.domain.model.Exchange
import com.im.bitcoinexchange.presentation.components.ExchangeCard
import com.im.bitcoinexchange.presentation.ui.theme.BitcoinExchangeTheme
import com.im.bitcoinexchange.presentation.ui.theme.Fonts
import com.im.bitcoinexchange.presentation.viewmodel.ExchangeViewModel
import com.im.bitcoinexchange.util.NetworkState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private val exchangeModel: ExchangeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BitcoinExchangeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color(0xFFF2F2FD)) {
                    MainScreen(exchangeModel)
                }
            }
        }
    }


    @Composable
    fun MainScreen(exchangeModel: ExchangeViewModel) {

        val exchanges = exchangeModel.exchanges.value
        val updated = remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Header(exchangeModel, updated.value)

            exchanges?.let { result ->

                when (result) {

                    is NetworkState.Success -> {

                        result.data?.forEach {
                            Layout(exchanges = it)
                            updated.value = it.updated
                        }

                    }

                    is NetworkState.Error -> {
                        Toast.makeText(this@MainActivity, "${result.error}", Toast.LENGTH_LONG)
                            .show()
                    }


                }


            }
        }


    }


    @Composable
    fun Layout(exchanges: Exchange) {

        LazyColumn(
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {


            item {
                ExchangeCard(
                    symbols = exchanges.gbpSymbol,
                    currency = exchanges.gbpCode,
                    rate = exchanges.gbpRate_float
                )
            }

            item {
                ExchangeCard(
                    symbols = exchanges.usdSymbol,
                    currency = exchanges.usdCode,
                    rate = exchanges.usdRate_float
                )
            }

            item {
                ExchangeCard(
                    symbols = exchanges.eurSymbol,
                    currency = exchanges.eurCode,
                    rate = exchanges.eurRate_float
                )
            }

        }

    }


    @Composable
    fun Header(exchangeModel: ExchangeViewModel, value: String) {


        Card(
            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 12.dp, start = 12.dp, end = 12.dp),
            elevation = 8.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
            ) {

                Column(
                    modifier = Modifier.padding(top = 30.dp, start = 20.dp)
                ) {

                    Text(
                        text = "Bitcoin Exchange",
                        style = TextStyle(
                            fontSize = 26.sp,
                            color = Color.Black,
                            fontFamily = Fonts
                        ),
                    )
                    Spacer(modifier = Modifier.padding(12.dp))
                    Text(
                        text = "Last updated",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontFamily = Fonts
                        ),
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "$value",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontFamily = Fonts
                        ),
                    )

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.76f)
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Button(
                        onClick = {
                            exchangeModel.startRunning()
                        },
                        modifier = Modifier
                            .width(130.dp)
                            .height(55.dp),
                        shape = RoundedCornerShape(50.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF400080))
                    ) {
                        Text(
                            text = "Start",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        )
                    }

                    Button(
                        onClick = {
                            exchangeModel.stopRunning()
                        },
                        modifier = Modifier
                            .width(130.dp)
                            .height(55.dp),
                        shape = RoundedCornerShape(50.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFCBC3E3))
                    ) {
                        Text(
                            text = "Stop",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color(0xFF400080)
                            )
                        )
                    }

                }


            }
        }


    }


}
