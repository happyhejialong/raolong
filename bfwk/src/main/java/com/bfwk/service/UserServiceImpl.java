package com.bfwk.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfwk.common.utils.CollectionUtils;
import com.bfwk.common.utils.LimitClauseUtils;
import com.bfwk.exception.WkException;
import com.bfwk.mapper.PermissionMapper;
import com.bfwk.mapper.UserMapper;
import com.bfwk.model.Permission;
import com.bfwk.model.PermissionExample;
import com.bfwk.model.User;
import com.bfwk.model.UserExample;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    /****
     * 通过用户名密码查找用户
     * 
     * @throws Exception
     */
    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws Exception {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.createCriteria().andPasswordEqualTo(password);
        User user = CollectionUtils.getFirst(userMapper.selectByExample(example));
        if (user == null) {
            throw new WkException("用户名或密码错误");
        }
        // TODO 修改用户的登录时间
        return user;
    }

    @Override
    public List<User> findAllUser(int number) {
        UserExample example = new UserExample();
        example.setLimitByClause(LimitClauseUtils.makeLimitClause((number - 1) * 10, 10));
        return userMapper.selectByExample(example);
    }

    /***
     * 通过用户名查询永华
     */
    @Override
    public User findUserByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        return CollectionUtils.getFirst(userMapper.selectByExample(example));
    }

    /***
     * 查询当前用户的权限
     */
    @Override
    public List<String> findAllUserPermissions(Integer id) {
        PermissionExample example = new PermissionExample();
        example.createCriteria().andUserIdEqualTo(id);
        List<Permission> permissions = permissionMapper.selectByExample(example);
        List<String> permissionValues = new ArrayList<String>();
        for (Permission per : permissions) {
            permissionValues.add(per.getPermission());
        }
        return permissionValues;
    }

    /***
     * 修改用户余额
     * 
     * @throws WkException
     */
    @Override
    public void updateBalance(String cardID, Double balance) throws WkException {
        ;
        int updateUserBalanceFlag = userMapper.updateBalance(cardID, balance);
        if (updateUserBalanceFlag == 0) {
            throw new WkException("该证件号无用户对应");
        }
    }

    /****
     * 修改用户信息
     * 
     * @throws Exception
     */
    @Override
    public void update(User user) throws Exception {
        int updateFlag = userMapper.updateByPrimaryKeySelective(user);
        if (updateFlag != 1) {
            throw new WkException("修改用户记录数失败");
        }
    }

    /****
     * 注册用户
     * 
     * @throws Exception
     */
    @Override
    public void register(User user) throws Exception {
        int insertUserFlag = userMapper.insert(user);
        if (insertUserFlag != 1) {
            throw new WkException("新增记录不为1，失败");
        }
    }

    /****
     * 删除用户
     * 
     * @throws WkException
     */
    @Override
    public void delete(Integer[] id) throws Exception {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(Arrays.asList(id));
        int deleteUserFlag = userMapper.deleteByExample(userExample);
        if (deleteUserFlag != id.length) {
            throw new WkException("实际删除记录条数和需要删除的记录条数不一致");
        }

    }

}
