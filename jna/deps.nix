with import <nixpkgs> { };
runCommand "dummy" {
  buildInputs = [ groovy ];
  shellHook = "export CLASSPATH=${xlibs.libX11.out}/lib";
} ""
