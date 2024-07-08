package br.com.jpegsinng.core.usecase.base

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

abstract class UseCase<in P, R> {
    operator fun invoke(params: P): Flow<ResultStatus<R>> =
        flow {
            emit(ResultStatus.Loading)
            emit(execute(params))
        }.catch { throwable ->
            emit(ResultStatus.Error(throwable))
        }

    protected abstract fun execute(params: P): ResultStatus<R>
}

abstract class PagingUseCase<in P, R : Any> {
    operator fun invoke(params: P): Flow<PagingData<R>> = createFlowObservable(params)

    protected abstract fun createFlowObservable(parameters: P): Flow<PagingData<R>>
}
