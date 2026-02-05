package com.example.composeplayground

import WellnessTask
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@Composable
fun WellnessTaskList (
    modifier: Modifier = Modifier,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    list: List<WellnessTask> = remember { getWellnessTask() }

){
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = {task -> task.id}
            ) {task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onClose = {onCloseTask(task) },
                onCheckChanged = { checked -> onCheckedTask(task,checked)}
            )
        }
    }
}

private fun getWellnessTask() = List(30){ i -> WellnessTask(i,"Task # $i") }