
extrn lirent:proc, ecrent:proc
 extrn ecrbool:proc
 extrn ecrch:proc, ligsuiv:proc
 .model SMALL
 .586
 .CODE
 debut :
 STARTUPCODE
mov bp,sp
 sub sp,10
push word ptr [bp-2]
push word ptr 2
push word ptr 3
pop bx
 pop ax
 imul bx
 push ax
pop bx
 pop ax
 add ax,bx
 push ax
pop ax
 mov word ptr [bp-10],ax
push word ptr [bp-10]
call ecrent
call ligsuiv
push word ptr [bp-2]
push word ptr 2
push word ptr 2
push word ptr 1
pop bx
 pop ax
 add ax,bx
 push ax
push word ptr [bp-2]
pop bx
 pop ax
 add ax,bx
 push ax
pop bx
 pop ax
 imul bx
 push ax
pop bx
 pop ax
 add ax,bx
 push ax
call ecrent
nop
 EXITCODE
 End debut
