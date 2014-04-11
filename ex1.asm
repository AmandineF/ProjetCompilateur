;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE

debut :
STARTUPCODE

main:
;ouvbloc 10
enter 10,0
;iConst
push word ptr 10

;iConst
push word ptr 20

;iConst
push word ptr 2

;idiv
pop bx
pop ax
cwd
 idiv bx
push ax

;iadd
pop bx
pop ax
add ax,bx
push ax

;iConst
push word ptr 5

;idiv
pop bx
pop ax
cwd
 idiv bx
push ax

;iStore
pop ax
mov word ptr [bp-2],ax

;iLoad
push word ptr [bp-2]

;ecrireEnt
call ecrent

;aLaLigne
call ligsuiv

;iLoad
push word ptr [bp-2]

;iConst
push word ptr 3

;iLoad
push word ptr [bp-2]

;imul
pop bx
pop ax
imul bx
push ax

;iadd
pop bx
pop ax
add ax,bx
push ax

;iConst
push word ptr 10

;isub
pop bx
pop ax
sub ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-4],ax

;iLoad
push word ptr [bp-4]

;ecrireEnt
call ecrent

;aLaLigne
call ligsuiv

;iConst
push word ptr 2

;inot
pop ax
mov bx,-1 
imul bx 
 push ax

;iConst
push word ptr 3

;inot
pop ax
mov bx,-1 
imul bx 
 push ax

;imul
pop bx
pop ax
imul bx
push ax

;inot
pop ax
mov bx,-1 
imul bx 
 push ax

;iConst
push word ptr 7

;inot
pop ax
mov bx,-1 
imul bx 
 push ax

;isub
pop bx
pop ax
sub ax,bx
push ax

;ecrireEnt
call ecrent

;aLaLigne
call ligsuiv

;ecrireChaine
.DATA
mess0 DB "ce programme a du ecrire 4 puis 6 puis 1$"
.CODE
lea dx,mess0
push dx
call ecrch

;queue
nop
EXITCODE
end