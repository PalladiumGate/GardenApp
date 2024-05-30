package com.csm.gardenapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csm.gardenapp.R
import com.csm.gardenapp.presentation.component.ScreenTitle

val aboutUsText = buildAnnotatedString {
    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
        append("Добро пожаловать в наше приложение для садовников!\n\n")
    }
    append("Мы рады приветствовать вас в нашем приложении, созданном специально для тех, кто увлечен садоводством. Наше приложение объединяет в себе полезные инструменты и информацию, которая поможет вам в вашем садоводческом опыте.\n\n")
    append("Что вы найдете в нашем приложении:\n\n")
    append("1. Справочник растений: Узнайте больше о различных растениях, их особенностях, способах посадки и ухода.\n\n")
    append("2. Календарь посадок: Планируйте свои посадки с учетом оптимальных дат, чтобы получить лучший урожай.\n\n")
    append("3. Личные заметки: Ведите учет ваших наблюдений, планов и идей, чтобы делиться ими с другими садоводами или просто сохранить для себя.\n\n")
    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
        append("Наша цель - помочь вам сделать ваш сад красивым и урожайным.\n\n")
    }
    append("Если у вас есть предложения по улучшению приложения или вопросы, пожалуйста, свяжитесь с нами через раздел обратной связи в приложении.\n\n")
    append("Благодарим вас за использование нашего приложения и желаем вам успешного садоводческого сезона!")
}

@Composable
fun AboutUsScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ) {
                ScreenTitle(
                    modifier = Modifier.padding(start = 20.dp),
                    title = stringResource(id = R.string.about_us)
                )
            }

            Text(
                text = aboutUsText,
                fontSize = 19.sp,
                modifier = Modifier.padding(15.dp, top = 20.dp)
            )
        }
    }
}

@Composable
@Preview
fun AboutUsScreenPreview() {
    AboutUsScreen()
}