package com.example.google_maps

import android.Manifest
import android.annotation.SuppressLint
import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.Bundle
import android.os.CancellationSignal
import android.provider.ContactsContract
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.google_maps.ui.theme.CustomTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    private var cancellationSignal: CancellationSignal? = null

    var ch: MutableState<Boolean>?=null
    var chAlert: MutableState<Boolean>?=null


    @RequiresApi(Build.VERSION_CODES.Q)
    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intentMaps = Intent(this, ComposeMaps::class.java)
        val intentRecuclerView = Intent(this, RecuclerView::class.java)
        val intentGradient = Intent(this, Gradient::class.java)
        val intentSearch = Intent(this, SearchView::class.java)
        val intentButtonNavigationView = Intent(this, ButtonNavigationView::class.java)
        val intentAdmob = Intent(this, AdMobCompose::class.java)
        val intentTab = Intent(this, TabAct::class.java)
        val intentAnimated = Intent(this, AnimatedAct::class.java)
        val intentPager = Intent(this, PagerAct::class.java)
        val intentAuthentication  = Intent(this, Authentication::class.java)
        val intentVideo  = Intent(this, VideoAct::class.java)
        val intentApiAct  = Intent(this, ApiAct::class.java)
        val intentSqlRoom = Intent(this,SqlRoomAct::class.java)
        val intentShimmer = Intent(this,ShimmerAct::class.java)
        val intentExpandableCard = Intent(this,ExpandableCardAct::class.java)
        val intentTimerPickers = Intent(this,TimePickers::class.java)
        val intentGoogleButton = Intent(this,GoogleButton::class.java)
        val intentNavigationDrawerCustom = Intent(this,NavigationDrawerCustom::class.java)
        val intentTimer = Intent(this,TimeAct::class.java)
        val intentList = Intent(this, ListItemAct::class.java)
        val intentSwipeRefresh = Intent(this, SwipeRefresh::class.java)
        val intentSwipeToDismiss = Intent(this, Swipe::class.java)
        val intentSwipe = Intent(this, SwipeComposeReveal::class.java)
        val intentLazyVerticalGrid = Intent(this, LazyVerticalGrid::class.java)
        val intentWebView = Intent(this, WebView::class.java)
        val intentNavigationDrawer = Intent(this, NavigationDrawer::class.java)
        val intentNavigation = Intent(this, Navigation::class.java)
        val intentDagger = Intent(this, DaggerAct::class.java)
        val intentGoogleNotesBottomBar = Intent(this, GoogleNotesBottomBarAct::class.java)
        val intentScrollToTopBottom = Intent(this, ScrollToTopBottomAct::class.java)
        val intentVerticalHorizontalScroll = Intent(this, VerticalHorizontalScroll::class.java)
        val intentBarCode = Intent(this, BarCodeAct::class.java)
        val intentNotification = Intent(this, NotificationAct::class.java)


        setContent {
            val them = remember { mutableStateOf(true)}
            val showDialog = remember { mutableStateOf(false)}

            ch = remember{ mutableStateOf(false)}
            chAlert = remember{ mutableStateOf(false)}

            CustomTheme(them.value){
                        Surface(color = colors.background) {

                            if (ch!!.value){
                                Scaffold(bottomBar = {
                                    Row (modifier = Modifier.background(Color.Black)){
                                        when(them.value){
                                            true->{
                                                Text("Dark",Modifier.padding(all = 5.dp))
                                                Image(painter = painterResource(id = R.drawable.dark), contentDescription = null,Modifier.padding(all = 5.dp))
                                            }
                                            false->{
                                                Text("Light",Modifier.padding(all = 5.dp))
                                                Image(painter = painterResource(id = R.drawable.light), contentDescription = null,Modifier.padding(all = 5.dp))
                                            }
                                        }

                                        Column {
                                            Switch(checked = them.value, onCheckedChange ={
                                                them.value = it
                                            },Modifier.padding(all = 5.dp))
                                        }

                                    }
                                }){
                                    LazyColumn{
                                        item{
                                            Column {
                                                ComposeButton("GoogleMap",intentMaps)
                                                ComposeButton(text = "RecuclerView", intent = intentRecuclerView)
                                                ComposeButton(text = "Gradient", intent = intentGradient)
                                                ComposeButton(text = "SearchView", intent = intentSearch)
                                                ComposeButton(text = "ButtonNavigationView", intent = intentButtonNavigationView)
                                                ComposeButton(text = "NavigationDrawerCustom", intent = intentNavigationDrawerCustom)
                                                ComposeButton(text = "AdMob", intent = intentAdmob)
                                                ComposeButton(text = "Tab", intent = intentTab)
                                                ComposeButton(text = "Animated", intent = intentAnimated)
                                                ComposeButton(text = "Pager", intent = intentPager)
                                                ComposeButton(text = "Authentication", intent = intentAuthentication)
                                                ComposeButton(text = "Video", intent = intentVideo)
                                                ComposeButton(text = "Api", intent = intentApiAct)
                                                ComposeButton(text = "SqlRoom", intent = intentSqlRoom)
                                                ComposeButton(text = "Shimmer", intent = intentShimmer)
                                                ComposeButton(text = "ExpandableCardAct", intent = intentExpandableCard)
                                                ComposeButton(text = "TimerPickers", intent = intentTimerPickers)
                                                ComposeButton(text = "GoogleButton", intent = intentGoogleButton)
                                                ComposeButton(text = "Timer", intent = intentTimer)
                                                ComposeButton(text = "List", intent = intentList)
                                                ComposeButton(text = "SwipeRefresh", intent = intentSwipeRefresh)
                                                ComposeButton(text = "SwipeToDismiss", intent = intentSwipeToDismiss)
                                                ComposeButton(text = "Swipe", intent = intentSwipe)
                                                ComposeButton(text = "LazyVerticalGrid", intent = intentLazyVerticalGrid)
                                                ComposeButton(text = "WebView", intent = intentWebView)
                                                ComposeButton(text = "NavigationDrawer", intent = intentNavigationDrawer)
                                                ComposeButton(text = "Navigation", intent = intentNavigation)
                                                ComposeButton(text = "Dagger", intent = intentDagger)
                                                ComposeButton(text = "GoogleNotesBottomBarAct", intent = intentGoogleNotesBottomBar)
                                                ComposeButton(text = "ScrollToTopBottom", intent = intentScrollToTopBottom)
                                                ComposeButton(text = "VerticalHorizontalScroll", intent = intentVerticalHorizontalScroll)
                                                ComposeButton(text = "BarCode", intent = intentBarCode)
                                                ComposeButton(text = "Notification", intent = intentNotification)

                                            }
                                        }
                                    }
                                }
                            }else{
                                CustomKeyboard()
                            }
                        }
                }
            }
        }

    private val authenticationCallback: BiometricPrompt.AuthenticationCallback =
        @RequiresApi(Build.VERSION_CODES.P)
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                super.onAuthenticationSucceeded(result)
                ch?.value = true
                //Toast.makeText(this@MainActivity, "Authentication Succeeded", Toast.LENGTH_SHORT).show()
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                super.onAuthenticationError(errorCode, errString)

                when (errorCode) {
                    11 -> {
                        chAlert?.value = true
                    }
                    7 -> {
                        Toast.makeText(this@MainActivity, "Количество попыток закончилочь, подождите 30 секунд", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Toast.makeText(this@MainActivity, "Authentication Error code: $errorCode", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
            }
            override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
                super.onAuthenticationHelp(helpCode, helpString)
            }
        }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkBiometricSupport(): Boolean {
        val keyGuardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

        if (!keyGuardManager.isDeviceSecure) {
            return true
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_BIOMETRIC) != PackageManager.PERMISSION_GRANTED) {
            return false
        }

        return packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)
    }

    @SuppressLint("MissingPermission")
    @RequiresApi(Build.VERSION_CODES.Q)
    private fun launchBiometric() {
        if (checkBiometricSupport()) {
            val biometricPrompt = BiometricPrompt.Builder(this)
                .apply {
                    setTitle(getString(R.string.prompt_info_title))
                    setSubtitle(getString(R.string.prompt_info_subtitle))
                    setDescription(getString(R.string.prompt_info_description))
                    setConfirmationRequired(false)
                    setNegativeButton(getString(R.string.prompt_info_use_app_password), mainExecutor, { _, _, ->
                        chAlert?.value = true
                    })
                }.build()

            biometricPrompt.authenticate(getCancellationSignal(), mainExecutor, authenticationCallback)
        }
    }

    private fun getCancellationSignal(): CancellationSignal {
        cancellationSignal = CancellationSignal()
        cancellationSignal?.setOnCancelListener {
            Toast.makeText(this, "Authentication Cancelled Signal", Toast.LENGTH_SHORT).show()
        }

        return cancellationSignal as CancellationSignal
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    @Composable
    fun CustomKeyboard() {
        val inputVal = remember { mutableStateOf("") }
        val scrollState = rememberScrollState()


        CustomKeyboard(
            input = inputVal,
            scrollState = scrollState,
            onClick = { digit ->
                inputVal.value += digit.toString()
            }
        )
    }

    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.Q)
    @Composable
    fun CustomKeyboard(
        input: MutableState<String>,
        scrollState: ScrollState,
        onClick: (digit: Char) -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))


            Text(
                text = input.value,
                fontSize = 32.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .weight(1f)
                    .padding(4.dp),
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                NumberButton(number = "1", onClick = onClick, modifier = Modifier.weight(1f))
                NumberButton(number = "2", onClick = onClick, modifier = Modifier.weight(1f))
                NumberButton(number = "3", onClick = onClick, modifier = Modifier.weight(1f))
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                NumberButton(number = "4", onClick = onClick, modifier = Modifier.weight(1f))
                NumberButton(number = "5", onClick = onClick, modifier = Modifier.weight(1f))
                NumberButton(number = "6", onClick = onClick, modifier = Modifier.weight(1f))
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                NumberButton(number = "7", onClick = onClick, modifier = Modifier.weight(1f))
                NumberButton(number = "8", onClick = onClick, modifier = Modifier.weight(1f))
                NumberButton(number = "9", onClick = onClick, modifier = Modifier.weight(1f))
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                OutlinedButton(
                    onClick = {
                        launchBiometric()
                    },
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .padding(4.dp),
                    border = ButtonDefaults.outlinedBorder.copy(
                        brush = SolidColor(colors.primary)
                    )
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_fingerprint_24), contentDescription = null, Modifier.size(50.dp))
                }

                NumberButton(number = "0", onClick = onClick, modifier = Modifier.weight(1f))

                OutlinedButton(
                    onClick = {
                        if (input.value == "1234"){
                            ch?.value = true
                        }else{
                            input.value = ""
                        }
                    },
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .padding(4.dp),
                    border = ButtonDefaults.outlinedBorder.copy(
                        brush = SolidColor(colors.primary)
                    )
                ) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = null, Modifier.size(50.dp))
                }
            }
        }
    }

    @Composable
    private fun NumberButton(
        number: String,
        onClick: (digit: Char) -> Unit,
        modifier: Modifier = Modifier
    ) {
        OutlinedButton(
            onClick = {
                @OptIn(ExperimentalStdlibApi::class)
                onClick(number.toInt().digitToChar())
            },
            modifier = modifier
                .aspectRatio(1f)
                .padding(4.dp),
            border = ButtonDefaults.outlinedBorder.copy(
                brush = SolidColor(colors.primary)
            )
        ) {
            Text(
                text = number.toString(),
                fontSize = 30.sp,
                color = colors.primary
            )
        }
    }

    @Composable
    fun ComposeButton(text:String,intent: Intent) {
        val context = LocalContext.current
        Button(onClick = {
            context.startActivity(intent)
        },modifier = Modifier
            .fillMaxWidth()
            .padding(top = 13.dp)) {
            Text(text = text)
        }
    }
}

