extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE
 debut :
STARTUPCODE
mov bp,sp
sub sp,4
.DATA
mess0 DB "c1=$"
.CODE
lea dx,mess0
push dx
call ecrch
lea dx,[bp-2]
push dx
call lirent
call ligsuiv
push word ptr [bp-2]
call ecrent
call ligsuiv
push word ptr 2
push word ptr [bp-2]
pop bx
pop ax
imul bx
push ax
push word ptr 3
push word ptr 4
pop bx
pop ax
imul bx
push ax
pop bx
pop ax
add ax,bx
push ax
push word ptr 5
pop bx
pop ax
sub ax,bx
push ax
call ecrent
call ligsuiv
.DATA
mess1 DB "factorielle 5= $"
.CODE
lea dx,mess1
push dx
call ecrch
push word ptr 5
push word ptr 4
pop bx
pop ax
imul bx
push ax
push word ptr 3
pop bx
pop ax
imul bx
push ax
push word ptr 2
pop bx
pop ax
imul bx
push ax
push word ptr 1
pop bx
pop ax
imul bx
push ax
call ecrent
nop
EXITCODE
End debut
