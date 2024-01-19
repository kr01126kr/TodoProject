package com.teamsparta.todoproject.domain.todo.model

import com.teamsparta.todoproject.domain.comment.model.CommentEntity
import com.teamsparta.todoproject.domain.todo.dto.TodoResponseDto
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "todo")
class TodoEntity(
    @Column(name = "title")
    var title:String,
    @Column(name = "content")
    var content:String,
    @Column(name = "nick_name")
    var nickName:String,
    @Column(name = "create_at")
    var creatAt:LocalDateTime,
    @OneToMany(mappedBy="todo")
    val comments:List<CommentEntity> = emptyList()
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var todoId:Long? = null
    @Column(name = "completed")
    private  var iscompleted:Boolean = false
    val completed:Boolean
        get() = iscompleted
    fun complete(){
       iscompleted = true
    }
}
fun TodoEntity.toResponse(): TodoResponseDto {
    return TodoResponseDto(
        todoId = todoId!!,
        title = title,
        content = content,
        nickName = nickName,
        createAt = creatAt,
        completed = completed
    )
}
