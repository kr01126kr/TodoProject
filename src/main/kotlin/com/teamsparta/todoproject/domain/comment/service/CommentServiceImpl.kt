package com.teamsparta.todoproject.domain.comment.service
import com.teamsparta.todoproject.domain.comment.model.CommentEntity
import com.teamsparta.todoproject.domain.comment.dto.CommentResponseDto
import com.teamsparta.todoproject.domain.comment.dto.CreateCommentDto
import com.teamsparta.todoproject.domain.comment.dto.DeleteCommentDto
import com.teamsparta.todoproject.domain.comment.dto.UpdateCommentDto
import com.teamsparta.todoproject.domain.comment.repository.CommentRepository
import com.teamsparta.todoproject.domain.exception.ModelNotFoundException
import com.teamsparta.todoproject.domain.todo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl(
    val commentRepository: CommentRepository,
    val todoRepository: TodoRepository
): CommentService {

    @Transactional
    override fun createComment( createCommentDto: CreateCommentDto): CommentResponseDto {
        val findTodoId = todoRepository.findByIdOrNull(createCommentDto.todoId)?: throw Exception("todo not found")

        val commentEntity= CommentEntity(
            commentContent = createCommentDto.commentContent,
            commentName = createCommentDto.commentName,
            commentPassword = createCommentDto.commentPassword,
            todo = findTodoId
        )
        val result = commentRepository.save(commentEntity)
        return CommentResponseDto.from(result)
    }
    @Transactional
    override fun updateComment( commentId: Long, updateCommentDto: UpdateCommentDto): CommentResponseDto {
        val findComment =commentRepository.findByIdOrNull(commentId)?: throw ModelNotFoundException("comment",commentId)

        findComment.checkNameAndPassword(updateCommentDto.commentName,updateCommentDto.commentPassword)

        findComment.changContent(updateCommentDto)
        commentRepository.save(findComment)
        return CommentResponseDto.from(findComment)
    }
    @Transactional
    override fun deleteComment( commentId: Long,deleteCommentDto: DeleteCommentDto) {
        val findComment = deleteCommentDto.commentId?.let{commentRepository.findByIdOrNull(it)}?:throw Exception("comment not found")
        findComment.checkNameAndPassword(deleteCommentDto.commentName,deleteCommentDto.commentPassword)
        commentRepository.deleteById(deleteCommentDto.commentId)
        }
    }
