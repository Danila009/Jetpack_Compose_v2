package com.example.google_maps

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.google_maps.data.User
import com.example.google_maps.data.UserViewModel
import com.example.google_maps.ui.theme.Google_MapsTheme
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class SqlRoomAct : ComponentActivity() {


    private lateinit var mUserViewModel: UserViewModel


    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            
            val navCon = rememberNavController()
            mUserViewModel = ViewModelProvider(this@SqlRoomAct).get(UserViewModel::class.java)

            val id = remember{ mutableStateOf(0)}


            val firstName = remember { mutableStateOf("")}
            val lastName = remember { mutableStateOf("")}
            val age = remember { mutableStateOf(0)}

            Google_MapsTheme {
                Surface(color = MaterialTheme.colors.background) {

                    NavHost(navController = navCon, startDestination = "Insert"){
                        composable("Insert"){InsertFun(navCon = navCon)}
                        composable("Read"){ReadFun(navCon = navCon, id, firstName, lastName,age)}
                        composable("Update"){UpdateFun(id, navCon, User(id.value,firstName.value,lastName.value,age.value))}
                    }
                }
            }
        }
    }

    @Composable
    fun InsertFun(navCon:NavController){

        val firstName = remember { mutableStateOf("")}
        val lastName = remember { mutableStateOf("")}
        val age = remember { mutableStateOf("")}
        
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            OutlinedTextField(value = firstName.value, onValueChange = {firstName.value = it}, Modifier.padding(8.dp),label = { Text(
                text = "FirstName"
            )}, shape = AbsoluteRoundedCornerShape(10.dp))
            OutlinedTextField(value = lastName.value, onValueChange = {lastName.value = it}, Modifier.padding(8.dp),label = { Text(
                text = "LastName"
            )}, shape = AbsoluteRoundedCornerShape(10.dp))
            OutlinedTextField(value = age.value, onValueChange = {age.value = it}, Modifier.padding(8.dp), keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ), label = { Text(text = "Age")}, shape = AbsoluteRoundedCornerShape(10.dp))

            Button(onClick = {
                if (firstName.value.isNotEmpty() && lastName.value.isNotEmpty() && age.value.isNotEmpty()){
                    insertDataToDatabase(firstName.value, lastName.value, age.value.toInt(), this@SqlRoomAct)

                }else{
                    Toast.makeText(this@SqlRoomAct, "Заполните все поля", Toast.LENGTH_SHORT).show()
                }

            }, modifier = Modifier.padding(10.dp)) {
                Text(text = "Добавить")
            }
            Button(onClick = {
                navCon.navigate("Read")
            }, modifier = Modifier.padding(10.dp)) {
                Text(text = "Чтение")
            }
            Button(onClick = {
                mUserViewModel.deleteAllUsers()
            }, modifier = Modifier.padding(10.dp)) {
                Text(text = "Удалить все")
            }
        }
    }

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun ReadFun(navCon: NavController, id: MutableState<Int>, firstName:MutableState<String>, lastName: MutableState<String>, age: MutableState<Int>) {
        var userList:List<User> by remember {
            mutableStateOf(listOf<User>())
        }

        MainScope().launch {
            mUserViewModel.readAllData.observe(this@SqlRoomAct, Observer { user ->
                userList = user
            })
        }
            val list = userList

        LazyColumn(content = {
            items(list) {
                Lazy(list = it, navCon = navCon, id, firstName, lastName, age)
            }
        })

    }
    
    @Composable
    fun Lazy(list:User, navCon: NavController, id:MutableState<Int>, firstName:MutableState<String>, lastName: MutableState<String>, age: MutableState<Int>) {


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .border(1.dp, Color.Black, AbsoluteRoundedCornerShape(10.dp))
                .clickable {
                    navCon.navigate("Update")
                    id.value = list.id
                    firstName.value = list.firstName
                    lastName.value = list.lastName
                    age.value = list.age
                },
            shape = AbsoluteRoundedCornerShape(10.dp)
        ) {
            Row() {
               Column(verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally) {
                   Text(text = list.firstName, modifier = Modifier.padding(10.dp), fontWeight = FontWeight.Bold)
                   Text(text = list.lastName, modifier = Modifier.padding(10.dp))
               }
               Column(verticalArrangement = Arrangement.Bottom,
                   horizontalAlignment = Alignment.End,
                   modifier = Modifier.fillMaxSize()) {
                   Text(text = list.age.toString(), modifier = Modifier.padding(10.dp))
               } 
            }
        }
    }

    @Composable
    fun UpdateFun(id: MutableState<Int>, navCon: NavController, delete:User?){

        val firstName = remember { mutableStateOf("")}
        val lastName = remember { mutableStateOf("")}
        val age = remember { mutableStateOf("")}

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            OutlinedTextField(value = firstName.value, onValueChange = {firstName.value = it}, Modifier.padding(8.dp),label = { Text(
                text = "FirstName"
            )}, shape = AbsoluteRoundedCornerShape(10.dp))
            OutlinedTextField(value = lastName.value, onValueChange = {lastName.value = it}, Modifier.padding(8.dp),label = { Text(
                text = "LastName"
            )}, shape = AbsoluteRoundedCornerShape(10.dp))
            OutlinedTextField(value = age.value, onValueChange = {age.value = it}, Modifier.padding(8.dp), keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ), label = { Text(text = "Age")}, shape = AbsoluteRoundedCornerShape(10.dp))

            Button(onClick = {
                if (firstName.value.isNotEmpty() && lastName.value.isNotEmpty() && age.value.isNotEmpty()){
                    updateItem(firstName.value, lastName.value, age.value.toInt(),id.value)
                    navCon.navigate("Read")
                }else{
                    Toast.makeText(this@SqlRoomAct, "Заполните все поля", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text(text = "Продолжить")
            }

            Button(onClick = {
                navCon.navigate("Read")
                if (delete != null){
                    mUserViewModel.deleteUser(delete)
                }
            },modifier = Modifier.padding(10.dp)) {
                Text(text = "Удалить")
            }
        }
    }

    private fun insertDataToDatabase(firstName: String, lastName: String, age:Int, context:Context) {

        if(inputCheck(firstName, lastName, age)){
            // Create User Object
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            // Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(context, "Successfully added!", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun updateItem(firstName: String, lastName: String, age:Int, id:Int){


        if(inputCheck(firstName, lastName, age)){
            // Create User Object
            val updatedUser = User(id, firstName, lastName, age)
            // Update Current User
            mUserViewModel.updateUser(updatedUser)
            Toast.makeText(this, "Updated Successfully!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Please fill out all fields.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: Int): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.toString().isEmpty())
    }
}