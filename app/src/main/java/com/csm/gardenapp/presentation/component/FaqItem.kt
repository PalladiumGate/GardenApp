package com.csm.gardenapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csm.gardenapp.domain.model.Faq
import com.csm.gardenapp.ui.theme.Grey

@Composable
fun FaqItem(
    modifier: Modifier = Modifier,
    faq: Faq
) {
    Column(
        modifier = modifier
            .fillMaxWidth(0.8f)
            .background(color = Grey, shape = RoundedCornerShape(15.dp))
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = faq.question,
            fontSize = 21.sp, 
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center
        )
        Divider()
        Text(
            text = faq.answer,
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview(showBackground = true)
fun FaqItemPreview(){
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        FaqItem(faq = Faq("Как я могу выбрать месяц во вкладке календаря?", "Нажмите на месяц и в диалоговом окне выберите нужный Вам."))
    }
}