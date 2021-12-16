package com.example.google_maps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.google_maps.searchPackge.MainScreen
import com.example.google_maps.searchPackge.MainViewModel
import com.example.google_maps.ui.theme.Google_MapsTheme
import java.util.*

class SearchView : ComponentActivity() {

    val list = ArrayList<ListItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val textVal = remember { mutableStateOf(TextFieldValue("")) }
            Google_MapsTheme {

                    SearchCountryList(textVal = textVal)
                }

        }
    }
    @Composable
    fun SearchCountryList(textVal: MutableState<TextFieldValue>) {

        Scaffold(
            topBar = {
                TextField(
                    value = textVal.value,
                    onValueChange = { textVal.value = it },
                    placeholder = { Text(text = "Search Country Name") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = TextStyle(Color.Black, fontSize = 18.sp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(15.dp)
                                .size(24.dp)
                        )
                    },
                    trailingIcon = {
                        if (textVal.value != TextFieldValue("")) {
                            IconButton(
                                onClick = {
                                    textVal.value = TextFieldValue("")
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Close,
                                    contentDescription = "Close",
                                    modifier = Modifier
                                        .padding(15.dp)
                                        .size(24.dp)
                                )
                            }
                        }
                    },
                    singleLine = true,
                    shape = RectangleShape,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        cursorColor = Color.Black,
                        leadingIconColor = Color.Black,
                        trailingIconColor = Color.Black,
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            },content = {
                LazyColumn(textVal = textVal)
            }
        )
    }


    @Composable
    fun LazyColumn(textVal: MutableState<TextFieldValue>) {
        val countries = getListOfCountries()
        var filteredCountries: ArrayList<String>

        androidx.compose.foundation.lazy.LazyColumn(content = {

            val searchText = textVal.value.text
            filteredCountries = if (searchText.isEmpty()) {
                countries
            } else {
                val resultList = ArrayList<String>()
                for (country in countries) {
                    if (country.lowercase(Locale.getDefault()).contains(searchText.lowercase(Locale.getDefault()))) {
                        resultList.add(country)
                    }
                }
                resultList
            }
            items(filteredCountries) { filteredCountries ->
                ListColumn(
                    listSearch = filteredCountries
                )
            }
        })
    }

    @Composable
    fun getListOfCountries(): ArrayList<String> {
        val countryListWithEmojis = ArrayList<String>()

        for(i in 0 until 100){
            if (i==0){
                countryListWithEmojis.add("Compose ")
                countryListWithEmojis.add("Jetpack ")
                countryListWithEmojis.add("View ")
                countryListWithEmojis.add("Kotlin ")
                countryListWithEmojis.add("Java ")
                countryListWithEmojis.add("C++ ")
                countryListWithEmojis.add("C# ")
                countryListWithEmojis.add("Ruby ")
                countryListWithEmojis.add("Search ")
                countryListWithEmojis.add("Array ")
                countryListWithEmojis.add("List ")
                countryListWithEmojis.add("Swipe ")
                countryListWithEmojis.add("Text ")
                countryListWithEmojis.add("Pager ")
                countryListWithEmojis.add("Tab ")
                countryListWithEmojis.add("Data ")
                countryListWithEmojis.add("Canvas ")
                countryListWithEmojis.add("Button ")
                countryListWithEmojis.add("TextView ")
                countryListWithEmojis.add("String ")
                countryListWithEmojis.add("Int ")
                countryListWithEmojis.add("Float ")
                countryListWithEmojis.add("Sql ")
            }else{
                countryListWithEmojis.add("Compose $i")
                countryListWithEmojis.add("Jetpack $i")
                countryListWithEmojis.add("View $i")
                countryListWithEmojis.add("Kotlin $i")
                countryListWithEmojis.add("Java $i")
                countryListWithEmojis.add("C++ $i")
                countryListWithEmojis.add("C# $i")
                countryListWithEmojis.add("Ruby $i")
                countryListWithEmojis.add("Search $i")
                countryListWithEmojis.add("Array $i")
                countryListWithEmojis.add("List $i")
                countryListWithEmojis.add("Swipe $i")
                countryListWithEmojis.add("Text $i")
                countryListWithEmojis.add("Pager $i")
                countryListWithEmojis.add("Tab $i")
                countryListWithEmojis.add("Data $i")
                countryListWithEmojis.add("Canvas $i")
                countryListWithEmojis.add("Button $i")
                countryListWithEmojis.add("TextView $i")
                countryListWithEmojis.add("String $i")
                countryListWithEmojis.add("Int $i")
                countryListWithEmojis.add("Float $i")
                countryListWithEmojis.add("Sql $i")
            }
        }
        return countryListWithEmojis
    }

    @Composable
    fun ListColumn( listSearch:String) {
        Card(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),shape = AbsoluteRoundedCornerShape(20.dp)
        ) {
            Row {

                Column {
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp))

                    Text(text = listSearch, Modifier.padding(10.dp))

                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp))
                }

            }
        }
    }
}


