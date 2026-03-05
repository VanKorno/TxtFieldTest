package io.github.vankorno.txtfield._vm

import com.vankorno.vankornocompose.vm.VmHolder

object VmTycjalkaHolder : VmHolder() {
    val vmTycjalka by lazy { get<VmTycjalka>() }
}