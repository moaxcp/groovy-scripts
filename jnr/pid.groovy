#!/usr/bin/env groovy

@Grapes( 
    @Grab(group='com.github.jnr', module='jnr-ffi', version='2.1.7') 
)

import jnr.ffi.LibraryLoader

public interface GetPid {
    long getpid()
}

GetPid getpid = LibraryLoader.create(GetPid).load('c')
println getpid.getpid()
